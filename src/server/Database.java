package server;

import java.sql.Connection;
import java.sql.Statement;

public class Database {

    private final String[] tables = {"Users"};
  
    public Database(){
        dropDatabase();
        createDatabase();
    }

  
    private void dropDatabase() {

        Connection connection = null;
        final String URL = "jdbc:mysql://localhost/";
        final String DROPDATABASE = "DROP DATABASE IF EXISTS JavaSalesUI";

        try {
            connection = ConnectionFactory.getConnection(URL);

            Statement statement = connection.createStatement();
            statement.executeUpdate(DROPDATABASE);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void createDatabase() {
        Connection connection = null;
        final String URL = "jdbc:mysql://localhost/";
        final String CREATEDATABASE = "CREATE DATABASE JavaSalesUI";

        try {
            connection = ConnectionFactory.getConnection(URL);
            Statement statement = connection.createStatement();

            statement.executeUpdate(CREATEDATABASE);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTables(){
        Connection connection = null;

        try {

            connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
