package com.company.controllers;

import com.company.controllers.interfaces.IOrdersController;
import com.company.entities.Orders;

import java.sql.DriverManager;
import java.util.Scanner;

public class OrdersController extends Orders implements IOrdersController {

    // command lines
    @Override
    public void OrderLoop() {
        while (true) {
            System.out.println("Welcome to the Orders loop");
            System.out.println("Choose option:");
            System.out.println("[1] Show active customers");
            System.out.println("[2] Show order status of customers");
            System.out.println("[3] Show late delivered orders");

            // set commands
            Scanner input = new Scanner(System.in);
            int respond = input.nextInt();
            if (respond == 1) {
                findActiveCustomers();
            }
            if (respond == 2) {
                showOrderStatus();
            }
            if(respond == 3) {
                showLateDelivered();
            }

        }

    }

    @Override
    public void findActiveCustomers() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "abcde");
            stmt = con.createStatement();

            rs = stmt.executeQuery("\n" +
                    "select Customer.customer_id,customer_Fname, customer_Lname, customer_email\n" +
                    "From Customer\n" +
                    "Left join Orders\n" +
                    "on Customer.customer_id=Orders.customer_id\n" +
                    "where order_purchase_timestamp >'2016-01-01'");

            System.out.println("The customers who have made an order for the last 5 years: ");
            while (rs.next()) // Processing the result
                System.out.println(rs.getInt("customer_id") + "       " +
                        rs.getString("customer_Fname") + "       " +
                        rs.getString("customer_Lname") + "       " +
                        rs.getString("customer_email"));

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
    public void showOrderStatus() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "abcde");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select Customer.customer_id,customer_Fname, customer_Lname, customer_email, order_status\n" +
                    "From Customer\n" +
                    "Left join Orders\n" +
                    "on Customer.customer_id=Orders.customer_id\n" +
                    "where order_status = 'invoiced'");

            System.out.println("Order status invoiced: ");
            while (rs.next()) // Processing the result
                System.out.println(+rs.getInt("customer_id") + "       " +
                        rs.getString("customer_Fname") + "       " +
                        rs.getString("customer_Lname") + "       " +
                        rs.getString("customer_email") + "       " +
                        rs.getString("order_status") + "       ");

            rs = stmt.executeQuery("select Customer.customer_id,customer_Fname, customer_Lname, customer_email, order_status\n" +
                    "From Customer\n" +
                    "Left join Orders\n" +
                    "on Customer.customer_id=Orders.customer_id\n" +
                    "where order_status = 'shipped'");

            System.out.println("Order status shipped: ");
            while (rs.next()) // Processing the result
                System.out.println(+rs.getInt("customer_id") + "       " +
                        rs.getString("customer_Fname") + "       " +
                        rs.getString("customer_Lname") + "       " +
                        rs.getString("customer_email") + "       " +
                        rs.getString("order_status") + "       ");

            rs = stmt.executeQuery("select Customer.customer_id,customer_Fname, customer_Lname, customer_email, order_status\n" +
                    "From Customer\n" +
                    "Left join Orders\n" +
                    "on Customer.customer_id=Orders.customer_id\n" +
                    "where order_status = 'delivered'");

            System.out.println("Order status delivered: ");
            while (rs.next()) // Processing the result
                System.out.println(+rs.getInt("customer_id") + "       " +
                        rs.getString("customer_Fname") + "       " +
                        rs.getString("customer_Lname") + "       " +
                        rs.getString("customer_email") + "       " +
                        rs.getString("order_status") + "       ");

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
    public void showLateDelivered(){
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "abcde");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select customer_email,Orders.order_id, order_delivered_customer_date,oredr_estimated_delivery_date\n" +
                    "from Customer\n" +
                    "left join Orders\n" +
                    "on Customer.customer_id = Orders.customer_id\n" +
                    "where order_delivered_customer_date > oredr_estimated_delivery_date");

            System.out.println("The com.company.data of late delivered orders");
            while (rs.next()) // Processing the result
                System.out.println(rs.getString("customer_email") + "     " +
                        rs.getInt("order_id") + "     " +
                        rs.getString("order_delivered_customer_date") + "     " +
                        rs.getString("oredr_estimated_delivery_date")   );

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
