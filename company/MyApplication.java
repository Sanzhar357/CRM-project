package com.company;

import com.company.controllers.*;
import com.company.entities.*;

import java.util.Scanner;

public class MyApplication {
    private Scanner scanner = new Scanner(System.in);
    private CustomerController customer = new CustomerController();
    private ProductController item = new ProductController();
    private OrdersController tovar = new OrdersController();
    private Order_itemsController tovarD = new Order_itemsController();
    private CustomerInputController customer2 = new CustomerInputController();

    // application's main menu command lines
    public void start() {
        System.out.println("Welcome to user application!");
        System.out.println("Choees your option:");
        System.out.println("[1] - Customer com.company.data analysis");
        System.out.println("[2] - Product com.company.data analysis");
        System.out.println("[3] - Order_items table data analysis");
        System.out.println("[4] - Order table data analysis");
        System.out.println("[5] - Input the com.company.data of customer");

        // set commands of application's main menu
        int respond = scanner.nextInt();
        System.out.println("\n\n");
        do{
            if(respond == 1){
                customer.CustomerLoop();
            }
            if(respond == 2){
                item.ItemLoop();
            }
            if(respond == 3){
                tovarD.OrderItemLoop();
            }
            if(respond == 4){
                tovar.OrderLoop();
            }
            if(respond == 5){
                customer2.InputData();
            }
        }while (false);
    }  //choose one of the  option
}
