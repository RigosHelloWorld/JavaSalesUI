package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionFactory{
    

    private static final String URL = "jdbc:mysql://localhost:3306/JavaSalesUI";
    private static final String USER = "root";
    private static final String PASSWORD = "COLMAR2134";



    public static Connection getConnection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);

    }

    public static Connection getConnection(String url) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, USER, PASSWORD);

    }

    public static void closeConnection(ResultSet resultSet, Statement statement, Connection connection) throws Exception{

        if(resultSet!= null) resultSet.close();
        if(statement!= null) statement.close();
        if(connection!= null) connection.close();
    }
}
