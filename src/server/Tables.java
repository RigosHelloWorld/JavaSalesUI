package server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tables {

    private  ArrayList<String> tableNames = null;
    private  ArrayList<String> columnData = null;

    private Map<String, String> tables;

   
    public void init(){
        tables = new HashMap<>();
        setTableNames();
        setColumnData();
        createTableData();
    }


    private void createTableData() {

    
        for(int i=0; i < tableNames.size();i++){
            tables.put(tableNames.get(i), columnData.get(i));
        }

      
    }

    public Map<String, String> getTables() {
        return tables;
    }

    private void setTableNames() {
        tableNames = new ArrayList<>();
        tableNames.add("Users");
    }

    private void setColumnData() {
        columnData = new ArrayList<>();
        columnData.add("(user VARCHAR(255) not NULL, " + "password VARCHAR(255) not NULL)");
    }
}
