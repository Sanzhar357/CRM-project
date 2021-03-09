package com.company.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dateBase implements sqlConnection{
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/CRM DB";
        try {
            // Here we load the driver's class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "abcde");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            try {
                throw e;
            } catch (ClassNotFoundException | SQLException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        }
        return null;
    }
}
