package com.hexaware.pps.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    public static Connection getDBConnection() throws SQLException {
        FileReader fr = null;
        Properties prop = new Properties();

        try {
            fr = new FileReader("src/db.properties");  
            prop.load(fr);
        } catch (IOException e) {
            System.out.println("Error reading database properties file: " + e.getMessage());
        }

        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        return DriverManager.getConnection(url, username, password);
    }
}
