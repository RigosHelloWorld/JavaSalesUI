import java.io.File;

import forms.LoginForm;
import server.AccountsDAO;
import server.Database;
import server.Encryptor;
import server.data.FILE_CONSTANTS;

public class Driver{
    public static void main(String[] args) {
        // System.out.println("My new Java Project");
        // LoginForm loginForm = new LoginForm();
        // loginForm.initiliaze();

      
        // ReadAccounts readAccounts = new ReadAccounts();

        // System.err.println(readAccounts.getAccount().toString());



        Database database = new Database();
        database.init();

        Encryptor.getHash("Hello");
        Encryptor.getHash("hello");

    }
}