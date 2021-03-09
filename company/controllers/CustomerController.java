package com.company.controllers;

import com.company.controllers.interfaces.IСustomerController;
import com.company.entities.Customer;

import java.sql.DriverManager;
import java.util.Scanner;

public class CustomerController extends Customer implements IСustomerController {
    // application menu command lines
    @Override
    public void CustomerLoop(){
        while (true) {
            System.out.println("Welcome to the user console!");
            System.out.println("Choose option:");
            System.out.println("[1] Show all com.company.data of table Customer ");
            System.out.println("[2] Age group com.company.data of table Customer");
            System.out.println("[3] Information of customer's geolocation");
            System.out.println("[4] Information about occupancy");

            // set commands for application menu
            Scanner input = new Scanner(System.in);
            int respond = input.nextInt();

            if (respond == 1) {
                showAllDataCustomer();
            }
            if (respond == 2) {
                selectTopAgeGroup();
            }
            if (respond == 3) {
                Geolocation();
            }
            if(respond == 4){
                determineOccupancy();
            }
        }
    }

    @Override
    public void showAllDataCustomer() {

        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            con = DriverManager.getConnection(connectionUrl, "postgres", "abcde");
            stmt = con.createStatement();

            rs = stmt.executeQuery(" select  customer_ID ,customer_Fname, customer_Lname, customer_phoneN, customer_city, customer_dateB,customer_gender from Customer order by customer_id ");
            System.out.println("customer_ID     customer_Fname          customer_Lname      customer_phoneN      customer_city      customer_dateB     customer_gender");
            while (rs.next()) // Processing the result
                System.out.println(rs.getInt("customer_id") + "                  "
                        + rs.getString("customer_Fname") + "          " +
                        rs.getString("customer_Lname") + "          " +
                        rs.getString("customer_phoneN") + "          " +
                        rs.getString("customer_city") + "           " +
                        rs.getString("customer_dateB") + "          " +
                        rs.getString("customer_gender") + "           "
                );
            //rs.getString("empl_date_of_birth")
        } catch (Exception e) {
            System.out.println("Exception occurred!");

            e.printStackTrace();
        } finally {

            try { // Close connection - clean up the system resources
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Exception occurred!");
            }
        }
        System.out.println("Finished!\n\n\n");
    }

    @Override
    public void selectTopAgeGroup() {


        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "abcde");
            stmt = con.createStatement();

            rs = stmt.executeQuery("SELECT count(DISTINCT customer_state) \n" +
                    "FROM Customer\n" +
                    "WHERE customer_dateB > '1991-01-01' and customer_dateB <= '2003-01-01';");


            while (rs.next()) // Processing the result
                System.out.println("The number of clients aged 18 to 30: " + rs.getInt("count")
                );


            rs = stmt.executeQuery("SELECT count(DISTINCT customer_state) \n" +
                    "FROM Customer\n" +
                    "WHERE customer_dateb > '1976-01-01' and customer_dateb <= '1991-01-01';");

            while (rs.next()) // Processing the result
                System.out.println("The number of clients aged 31 to 45: " + rs.getInt("count")
                );


            rs = stmt.executeQuery("SELECT count(DISTINCT customer_state) \n" +
                    "FROM Customer\n" +
                    "WHERE customer_dateb > '1961-01-01' and customer_dateb <= '1976-01-01';");

            while (rs.next()) // Processing the result
                System.out.println("The number of clients aged 46 to 60: " + rs.getInt("count")
                );


            rs = stmt.executeQuery("SELECT count(DISTINCT customer_state) \n" +
                    "FROM Customer\n" +
                    "WHERE  customer_dateb <= '1961-01-01';");


            while (rs.next()) // Processing the result
                System.out.println("The number of clients who are over 60 years old: " + rs.getInt("count")
                );

        } catch (Exception e) {
            System.out.println("Exception occurred!");
            e.printStackTrace();
        } finally {

            try { // Close connection - clean up the system resources
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Exception occurred!");
            }
        }
        System.out.println("Finished!\n\n\n");

    }

    @Override
    public void Geolocation() {

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "abcde");
            stmt = con.createStatement();
            // information about each state in context of customers
            rs = stmt.executeQuery("SELECT count(DISTINCT customer_state) \n" +
                    "FROM Customer\n");
            while (rs.next()) // Processing the result
                System.out.println("The number of States: " + rs.getInt("count")
                );

            //-----------------------------------------------

            System.out.println("The top 5 state"); // order by qty of customers
            rs = stmt.executeQuery("SELECT customer_state, COUNT(*) \n" +
                    "FROM Customer \n" +
                    "GROUP BY customer_state\n" +
                    "order by count desc\n" +
                    "limit 5");
            System.out.println("State           Qty");
            while (rs.next()) // Processing the result
                System.out.println(rs.getString("customer_state") + "         "+ rs.getInt("count")
                );

        } catch (Exception e) {
            System.out.println("Exception occurred!");
            e.printStackTrace();
        } finally {

            try { // Close connection - clean up the system resources
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Exception occurred!");
            }
        }
        System.out.println("Finished!\n\n\n");
    }

    @Override
    public void determineOccupancy(){

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "abcde");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select count(*) from Customer\n" +
                    "where customer_occupancy = 'student'");
            while (rs.next()) // Processing the result
                System.out.println("The number of student: " + rs.getInt("count")
                );


            rs = stmt.executeQuery("select count(*) from Customer\n" +
                    "where customer_occupancy = 'worker'");
            while (rs.next()) // Processing the result
                System.out.println("The number of worker: " + rs.getInt("count")
                );

            rs = stmt.executeQuery("select count(*) from Customer\n" +
                    "where customer_occupancy = 'retired'");
            while (rs.next()) // Processing the result
                System.out.println("The number of pensioners: " + rs.getInt("count")
                );

            rs = stmt.executeQuery("select count(*) from Customer\n" +
                    "where customer_occupancy = 'unemployed'");
            while (rs.next()) // Processing the result
                System.out.println("The number of unemployed people: " + rs.getInt("count")
                );


        } catch (Exception e) {
            System.out.println("Exception occurred!");
            e.printStackTrace();
        } finally {

            try { // Close connection - clean up the system resources
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Exception occurred!");
            }
        }
        System.out.println("Finished!\n\n\n");
    }
}
