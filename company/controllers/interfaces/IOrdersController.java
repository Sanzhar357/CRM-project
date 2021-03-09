package com.company.controllers.interfaces;

import java.sql.DriverManager;
import java.util.Scanner;

public interface IOrdersController {
    public void OrderLoop();

    public void findActiveCustomers();

    public void showOrderStatus();

    public void showLateDelivered();
}
