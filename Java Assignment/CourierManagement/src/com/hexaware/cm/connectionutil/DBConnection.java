package com.hexaware.cm.connectionutil;

import java.sql.*;
import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;

public class DBConnection {

    
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        Properties prop = new Properties();

        try (FileReader fr = new FileReader("src/database.properties")) {
            prop.load(fr);

            String url = prop.getProperty("url");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conn = DriverManager.getConnection(url, username, password);

        } catch (IOException e) {
            System.out.println("Error reading database.properties file.");
            e.printStackTrace();
        }

        return conn;
    }
}
