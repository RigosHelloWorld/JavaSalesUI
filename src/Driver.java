
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import helperClasses.ReadExcelFile;
import server.Database;
import windows.Inventory;
import windows.LoginForm;
import java.util.List;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args)  {

        createDataBase();
        createLoginForm();



    }

    public static  void createDataBase(){
        Database database = new Database();
        database.init();
    }

    public static void createLoginForm(){
        LoginForm loginForm = new LoginForm();
        loginForm.init();
    }

}