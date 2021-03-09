package com.company.controllers;

import com.company.controllers.interfaces.ICustomerInputController;
import com.company.entities.CustomerInput;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Scanner;

public class CustomerInputController extends CustomerInput implements ICustomerInputController {
    protected Scanner scan = new Scanner(System.in);
    @Override
    public void InputData() {
        System.out.println("Enter the customer_id: ");
        customer_ID = scan.nextInt();
        System.out.println("Fisrt name");
        customer_fName = scan.next();
        System.out.println("Last name");
        customer_lName = scan.next();
        System.out.println("Phone number");
        customer_phoneN = scan.next();
        System.out.println("City");
        customer_city = scan.next();
        System.out.println("Gender");
        customer_gender = scan.next();
        System.out.println("Date of Birth");
        customer_dateB = scan.next();
        System.out.println("Email");
        customer_email = scan.next();
        System.out.println("Country");
        customer_state = scan.next();
        System.out.println("Occupancy");
        customer_occupancy = scan.next();
        System.out.println("Available funds");
        customer_aFunds = scan.nextInt();

        try {
            // create a sql database connection
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "abcde");

            // create a sql date object so we can use it in our INSERT statement
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the sql insert statement
            String query = " insert into Customer (customer_ID,customer_fName,customer_lName, customer_phoneN, customer_gender, customer_dateB,customer_email, customer_city,customer_state,customer_occupancy,customer_aFunds)"
                    + " values (?, ?, ?,?, ?, ?,?, ?, ?,?, ?  )";

            // create the sql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, customer_ID);
            preparedStmt.setString(2, customer_fName);
            preparedStmt.setString(3, customer_lName);

            preparedStmt.setString(4, customer_phoneN);
            preparedStmt.setString(5, customer_gender);
            preparedStmt.setDate(6, Date.valueOf(customer_dateB));

            preparedStmt.setString(7, customer_email);
            preparedStmt.setString(8, customer_city);
            preparedStmt.setString(9, customer_state);

            preparedStmt.setString(10, customer_occupancy);
            preparedStmt.setInt(11, customer_aFunds);

            preparedStmt.execute();

            System.out.println("Executed!");

            con.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}
