package com.prog3.dbConnection; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConf {
    private Connection connection;

    public DatabaseConf() {
        String jdbcURL = System.getenv("JDBC_URL");
        System.out.println("aaa0: " + jdbcURL);
        String username = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");

        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
            if (connection != null) {
                System.out.println("Database connection established!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to connect to database.", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
