package org.game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    //static Connection connection = null;
    static String url = "jdbc:mysql://localhost:3306/";
    static String username = "root";
    static String databasePassword = "password";

    public static Connection getConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Connection dbConnection = null;
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        dbConnection = DriverManager.getConnection(url, username, databasePassword);
        return dbConnection;
    }
}
