import dataCreator.ReadAccounts;
import forms.LoginForm;

public class Driver{
    public static void main(String[] args) {
        System.out.println("My new Java Project");
        LoginForm loginForm = new LoginForm();
        loginForm.initiliaze();

      
        ReadAccounts readAccounts = new ReadAccounts();

        System.err.println(readAccounts.getAccount().toString());


    }
}