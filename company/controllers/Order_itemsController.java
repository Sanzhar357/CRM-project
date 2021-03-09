package com.company.controllers;

import com.company.controllers.interfaces.IOrder_itemsController;
import com.company.entities.Order_items;

import java.sql.DriverManager;
import java.util.Scanner;

public class Order_itemsController extends Order_items implements IOrder_itemsController {
    // command lines
    @Override
    public void OrderItemLoop() {
        while (true) {
            System.out.println("Welcome to the Order-Item loop");
            System.out.println("Choose option:");
            System.out.println("[1] Show top 5 the most expensive products of all time ");
            System.out.println("[2] Show top 5 the cheapest products of all time ");
            System.out.println("[3] Show top 3 the most expensive products during the last year ");
            System.out.println("[4] Show top 3 the cheapest products during the last year ");
            System.out.println("[5] Fund of Company");

            // set commands
            Scanner input = new Scanner(System.in);
            int respond = input.nextInt();
            if (respond == 1) {
                top5ExpensiveProducts();
            }
            if (respond == 2) {
                top5CheapestProducts();
            }
            if (respond == 3) {
                top3ExpensiveProductsDate();
            }
            if (respond == 4) {
                top3CheapestProductsDate();
            }
            if (respond == 5) {
                calculateFundOfCompany();
            }

        }
    }

    @Override
    public void top5ExpensiveProducts () {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "abcde");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select order_id, product_price from Order_items order by product_price desc limit 5");
            System.out.println("order_id   product_price");
            while (rs.next()) // Processing the result
                System.out.println(" " + rs.getInt("order_id") + "          "+ rs.getInt("product_price"));
        }

        catch (Exception e) {
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
    public void top5CheapestProducts () {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "abcde");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select order_id, product_price from Order_items order by product_price limit 5");
            System.out.println("order_id   product_price");
            while (rs.next()) // Processing the result
                System.out.println(" " + rs.getInt("order_id") + "         " + rs.getInt("product_price"));
        }

        catch (Exception e) {
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
    public void top3ExpensiveProductsDate () {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "abcde");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select order_id, product_price from Order_items where shipping_limit_date <'2018-12-12 23:59:59' AND shipping_limit_date >'2018-01-01 00:00:00' order by product_price desc limit 3 ");
            System.out.println("order_id   product_price");
            while (rs.next()) // Processing the result
                System.out.println(" " + rs.getInt("order_id") + "         " + rs.getInt("product_price"));
        }

        catch (Exception e) {
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
    public void top3CheapestProductsDate () {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "abcde");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select order_id, product_price from Order_items where shipping_limit_date <'2018-12-12 23:59:59' AND shipping_limit_date >'2018-01-01 00:00:00' order by product_price limit 3 ");
            System.out.println("order_id   product_price");
            while (rs.next()) // Processing the result
                System.out.println(" " + rs.getInt("order_id") + "         " + rs.getInt("product_price"));
        }

        catch (Exception e) {
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
    public void calculateFundOfCompany(){
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "abcde");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select sum(product_price+freight_value)  from Order_items");
            while (rs.next()) // Processing the result
                System.out.print(" " + rs.getInt("sum" )
                );
            System.out.println(" $");
        }

        catch (Exception e) {
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
