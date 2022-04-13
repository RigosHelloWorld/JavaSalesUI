
import server.Database;
import windows.LoginForm;


public class Driver {
    public static void main(String[] args) {

        // System.out.println("My new Java Project");
         LoginForm loginForm = new LoginForm();
         loginForm.initiliaze();

        Database database = new Database();
        database.init();

    }
}