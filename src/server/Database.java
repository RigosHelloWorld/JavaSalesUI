package server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import helperClasses.ReadExcelFile;

public class Database {

    public void init() {
        dropDatabase();
        createDatabase();
        createTables();
        loadUsers();
        loadInventory();
    }

    private void dropDatabase() {

        Connection connection = null;
        Statement statement = null;
        final String URL = "jdbc:mysql://localhost/";
        final String DROPDATABASE = "DROP DATABASE IF EXISTS JavaSalesUI";

        try {
            connection = ConnectionFactory.getConnection(URL);
            statement = connection.createStatement();
            statement.executeUpdate(DROPDATABASE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(null, statement, connection);
        }
    }

    private void createDatabase() {
        Connection connection = null;
        Statement statement = null;
        final String URL = "jdbc:mysql://localhost/";
        final String databaseName = "JavaSalesUI";
        final String CREATEDATABASE = "CREATE DATABASE " + databaseName;

        try {
            connection = ConnectionFactory.getConnection(URL);
            statement = connection.createStatement();
            statement.executeUpdate(CREATEDATABASE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(null, statement, connection);
        }

    }

    private void createTables() {
        Connection connection = null;
        Tables tables = null;
        Statement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            tables = new Tables();
            tables.init();

            for (Map.Entry<String, String> table : tables.getTables().entrySet()) {
                String tableData = "Create table " + table.getKey() + " " + table.getValue();
                statement.executeUpdate(tableData);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(null, statement, connection);
        }
    }

    private void loadUsers() {
        Scanner scanner = null;
        Connection connection = null;
        PreparedStatement preStatement = null;

        final String SQL_INSERT_STATEMENT = "INSERT INTO Accounts(account_usernames,account_password) values (?,?)";
        try {
            connection = ConnectionFactory.getConnection();
            preStatement = connection.prepareStatement(SQL_INSERT_STATEMENT);
            // if the file exist
            if (FILE_CONSTANTS.FILE_PATH_ACCOUNTS.exists()) {
                scanner = new Scanner(FILE_CONSTANTS.FILE_PATH_ACCOUNTS);
                String line = "";
                
                // while theres another line
                while (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                    String[] data = line.split(String.valueOf(FILE_CONSTANTS.FILE_SEPERATOR));
                    preStatement.setString(1, data[0]);
                    preStatement.setString(2, Encryptor.getHash(data[1].trim()));
                    preStatement.executeUpdate();
                }
            } else
                throw new Exception("File not found");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(null, preStatement, connection);
        }
    }

    private void loadInventory(){
        Connection conn = null;
        PreparedStatement preStatement = null;

        final String SQL_INSERT_STATEMENT = "INSERT INTO INVENTORY(slab_num,width,length, mfg_part_num) VALUES(?,?,?,?)";
        try{
            conn = ConnectionFactory.getConnection();
            preStatement = conn.prepareStatement(SQL_INSERT_STATEMENT);

            ReadExcelFile rx = new ReadExcelFile(FILE_CONSTANTS.INVENTORY_FILE_PATH);

            List<String> list = rx.getCellData();

            Iterator<String> itr = list.iterator();

            int colNum = 1;

            /**
             * We are currently hard coding the column iterations
             * 
             * Problem with this an outside user would not know without looking at the file how the data is structured
             */
            while(itr.hasNext()){

                switch(colNum){
                    case 1:{
                        preStatement.setInt(colNum++, Integer.parseInt(itr.next()));
                        
                        break;
                    }
                    case 2:{
                        preStatement.setDouble(colNum++, Double.parseDouble(itr.next()));
                        
                        break;

                    }
                    case 3:{
                        preStatement.setDouble(colNum++, Double.parseDouble(itr.next()));
                        
                        break;

                    }
                    case 4:{
                        preStatement.setString(colNum++, itr.next());
                        preStatement.executeUpdate();
                        //get rid of the "," that we used as a row seperator
                        itr.next();
                        colNum = 1; 
                        break;

                    }
                }
                
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static boolean validateUser(String userName, String password){

        Connection conn = null;
        Statement st = null;
        final String  VALIDATE_USER = "SELECT account_usernames, account_password FROM Accounts";


        try {
            conn = ConnectionFactory.getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(VALIDATE_USER);

            while(rs.next()){
               
                if(userName.equals(rs.getString("account_usernames"))){
                    if(Encryptor.getHash(password).equals(rs.getString("account_password"))) return true;
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}
