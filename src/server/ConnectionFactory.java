package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory{
    

    private static final String URL = "jdbc:mysql://localhost:3306/JavaSalesUI";
    private static final String USER = "YOUR_USERNAME";
    private static final String PASSWORD = "YOUR_PASSWORD";



    public static Connection getConnection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);

    }

    public static Connection getConnection(String url) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, USER, PASSWORD);

    }

    public static void closeConnection(ResultSet resultSet, Statement statement, Connection connection){

        if(resultSet!= null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        if(statement!= null){
            try {
                statement.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        if(connection!= null){
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
