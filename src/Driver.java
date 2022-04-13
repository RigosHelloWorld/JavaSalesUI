
import server.Database;
import windows.LoginForm;
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.FormulaEvaluator;  
import org.apache.poi.ss.usermodel.Row;  

public class Driver {
    public static void main(String[] args) {

        createDataBase();
        createLoginForm();

        

     



    }
   

    public static void createDataBase(){
        Database database = new Database();
        database.init();
    }

    public static void createLoginForm(){
        LoginForm loginForm = new LoginForm();
        loginForm.initiliaze();
    }

}