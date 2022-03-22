package server;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory{
    

    private static final String URL = "jdbc:mysql://localhost3306:JavaSalesUI/";
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
}
