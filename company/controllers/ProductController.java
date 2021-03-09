package com.company.controllers;

import com.company.controllers.interfaces.IProductController;
import com.company.entities.Product;

import java.sql.DriverManager;
import java.util.Scanner;

public class ProductController extends Product implements IProductController {
    // command lines
    @Override
    public void ItemLoop(){
        while (true){
            System.out.println("Welcome to the Product-loop");
            System.out.println("Choose option:");
            System.out.println("[1] The heaviest 5 products to transport");
            System.out.println("[2] Product: Name-length, Description-length");

            // set commands
            Scanner input = new Scanner(System.in);
            int respond = input.nextInt();

            if(respond == 1){

                massOfProduct();
            }
            if(respond == 2){
                letterOfNameDescrip();
            }
        }
    }

    @Override
    public void massOfProduct(){
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "abcde");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select product_id, product_weight_g\n" +
                    "from Products\n" +
                    "order by product_weight_g desc\n" +
                    "limit 5 ");

            System.out.println("The heaviest 5 products: ");
            System.out.println("product_id     mass(g)");
            while (rs.next()) // Processing the result
                System.out.println( rs.getInt("product_id")+ "       " + rs.getInt("product_weight_g"));

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
    public void letterOfNameDescrip(){
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "abcde");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select * from Products");
            while (rs.next()) // Processing the result
                System.out.println(" " + rs.getInt("product_id") + "      "
                        + rs.getInt("product_name_length") + " letter      "
                        + rs.getInt("product_description_length") + " letter      "
                );
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
