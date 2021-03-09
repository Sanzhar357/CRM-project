package com.company.entities;

import com.company.entities.Customer;

import java.sql.*;
import java.util.Scanner;
import java.util.Calendar;

public class CustomerInput  extends Customer {
    protected Scanner scan = new Scanner(System.in);
    protected String connectionUrl = "jdbc:postgresql://localhost:5432/CRM DB";
    protected Connection con = null;
    protected ResultSet rs = null;
    protected Statement stmt = null;

    public void InputData(){}; // data entry into the database
}
