package server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Map;
import java.util.Scanner;

import server.data.FILE_CONSTANTS;

public class Database {

    public void init() {
        dropDatabase();
        createDatabase();
        createTables();
        loadUsers();
    }

    private void dropDatabase() {

        Connection connection = null;
        final String URL = "jdbc:mysql://localhost/";
        final String DROPDATABASE = "DROP DATABASE IF EXISTS JavaSalesUI";

        try {
            connection = ConnectionFactory.getConnection(URL);

            Statement statement = connection.createStatement();
            statement.executeUpdate(DROPDATABASE);

            ConnectionFactory.closeConnection(null, statement, connection);

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

            ConnectionFactory.closeConnection(null, statement, connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void createTables() {
        Connection connection = null;
        Tables tables = null;

        try {
            connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();

            tables = new Tables();
            tables.init();

            for (Map.Entry<String, String> table : tables.getTables().entrySet()) {
                String tableData = "Create table " + table.getKey() + " " + table.getValue();

                statement.executeUpdate(tableData);
            }

            ConnectionFactory.closeConnection(null, statement, connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void loadUsers() {
        Scanner scanner = null;
        Connection connection = null;

        //ask the question 
        String sqlInsert = "INSERT INTO Users(user,password) values (?,?)";
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlInsert);

            //check if the file exist 
            if (FILE_CONSTANTS.FILE_PATH.exists()) {
                scanner = new Scanner(FILE_CONSTANTS.FILE_PATH);
                String line = "";
                String splitBy = ",";



                //while theres another line 
                while(scanner.hasNextLine()){
                     line = scanner.nextLine();
                     String[] data = line.split(splitBy);

                     statement.setString(1, data[0]);
                     //statement.setString(2, data[1]);
                     statement.setString(2, Encryptor.getHash(data[1]));
                     statement.executeUpdate();

                }

                

            }
            else throw new Exception("File not found");

            ConnectionFactory.closeConnection(null, statement, connection);



        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}
