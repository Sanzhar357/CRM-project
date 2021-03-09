package com.company.controllers.interfaces;

import java.sql.DriverManager;
import java.util.Scanner;

public interface IOrder_itemsController {
    public void OrderItemLoop();

    public void top5ExpensiveProducts ();

    public void top5CheapestProducts ();

    public void top3ExpensiveProductsDate ();

    public void top3CheapestProductsDate ();

    public void calculateFundOfCompany();
}
