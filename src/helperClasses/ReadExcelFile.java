package helperClasses;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;  
  
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import server.FILE_CONSTANTS;

import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;

public class ReadExcelFile {

    private  FileInputStream fileInputStream = null;

    //object to read the workbook
    
    /**
     * NOTE XSSFWorkbook : 
     * *****WORKS WITH EXCEL 2007 VERSION OR LATER****
     */
    private  XSSFWorkbook workbook = null;
    //object to read the sheets
    


    //constructor
    public ReadExcelFile(File filePath) throws IOException {
        
        //if the file doesnt exist throw an exception
        if(!filePath.exists()) throw new FileNotFoundException();

        fileInputStream = new FileInputStream(filePath);
        
        workbook = new XSSFWorkbook(fileInputStream);
    }

    public int getSheetCount(){
        return workbook.getNumberOfSheets();
        
    }

    public List<String> getSheetNames(){
        
        //create a list obj of string to hold the names
        List<String> list = new ArrayList<>();
        
        //loop through the sheets in the workbook
        for(int i=0; i < getSheetCount(); i++){
            list.add(workbook.getSheetName(i));
        }
        return list;
    }

    public List<String> getCellData(){

        //we are hardcoding the sheet we want to get
        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowItr = sheet.iterator();

        //skip the first row
        rowItr.next();
        List<String> list = new ArrayList<>();

        while(rowItr.hasNext()){
            Row row = rowItr.next();
            Iterator<Cell> cellItr = row.cellIterator();

            while(cellItr.hasNext()){
                Cell cell = cellItr.next();

                switch(cell.getCellType()){
                    case NUMERIC:{
                        list.add(cell.getNumericCellValue()+"");
                        break;
                    }
                    case STRING:{
                        list.add(cell.getStringCellValue());
                        break;
                    }
                }
            }
            list.add(String.valueOf(FILE_CONSTANTS.FILE_SEPERATOR));  
        }

        return list;
        
    }

 }


