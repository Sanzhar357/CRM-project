package com.company.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Statement;

public  class Customer {
    public int customer_ID;
    protected String customer_fName;
    protected String customer_lName;
    protected String customer_dateB;
    protected String customer_gender;
    protected String customer_phoneN;
    protected String customer_email;
    protected String customer_city;
    protected String customer_state;
    protected String customer_occupancy;
    protected int customer_aFunds;

    protected String connectionUrl = "jdbc:postgresql://localhost:5432/CRM DB";
    protected Connection con = null;
    protected ResultSet rs = null;
    protected Statement stmt = null;

    public Customer() {

    }

    public Customer(String customer_fName, String customer_lName, String customer_dateB, String customer_gender, String customer_phoneN, String customer_email, String customer_city, String customer_state, String customer_occupancy) {
        setCustomer_fName(customer_fName);
        setCustomer_lName(customer_lName);
        setCustomer_dateB(customer_dateB);
        setCustomer_gender(customer_gender);
        setCustomer_phoneN(customer_phoneN);
        setCustomer_email(customer_email);
        setCustomer_city(customer_city);
        setCustomer_state(customer_state);
        setCustomer_occupancy(customer_occupancy);

    }

    public Customer(int customer_ID, String customer_fName, String customer_lName, String customer_dateB, String customer_gender, String customer_phoneN, String customer_email, String customer_city, String customer_state, String customer_occupancy, int customer_aFunds) {
        setCustomer_ID(customer_ID);
        setCustomer_fName(customer_fName);
        setCustomer_lName(customer_lName);
        setCustomer_dateB(customer_dateB);
        setCustomer_gender(customer_gender);
        setCustomer_phoneN(customer_phoneN);
        setCustomer_email(customer_email);
        setCustomer_city(customer_city);
        setCustomer_state(customer_state);
        setCustomer_occupancy(customer_occupancy);
        setCustomer_aFunds(customer_aFunds);
    }

    public int getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        this.customer_ID = customer_ID;
    }

    public String getCustomer_fName() {
        return customer_fName;
    }

    public void setCustomer_fName(String customer_fName) {
        this.customer_fName = customer_fName;
    }

    public String getCustomer_lName() {
        return customer_lName;
    }

    public void setCustomer_lName(String customer_lName) {
        this.customer_lName = customer_lName;
    }

    public String getCustomer_dateB() {
        return customer_dateB;
    }

    public void setCustomer_dateB(String customer_dateB) {
        this.customer_dateB = customer_dateB;
    }

    public String getCustomer_gender() {
        return customer_gender;
    }

    public void setCustomer_gender(String customer_gender) {
        this.customer_gender = customer_gender;
    }

    public String getCustomer_phoneN() {
        return customer_phoneN;
    }

    public void setCustomer_phoneN(String customer_phoneN) {
        this.customer_phoneN = customer_phoneN;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_city() {
        return customer_city;
    }

    public void setCustomer_city(String customer_city) {
        this.customer_city = customer_city;
    }

    public String getCustomer_state() {
        return customer_state;
    }

    public void setCustomer_state(String customer_state) {
        this.customer_state = customer_state;
    }

    public String getCustomer_occupancy() {
        return customer_occupancy;
    }

    public void setCustomer_occupancy(String customer_occupancy) {
        this.customer_occupancy = customer_occupancy;
    }

    public double getCustomer_aFunds() {
        return customer_aFunds;
    }

    public void setCustomer_aFunds(int customer_aFunds) {
        this.customer_aFunds = customer_aFunds;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_ID = " + this.customer_ID +
                ", customer_fName = '" + this.customer_fName + '\'' +
                ", customer_lName = '" + this.customer_lName + '\'' +
                ", customer_dateB = '" + this.customer_dateB + '\'' +
                ", customer_gender=" + this.customer_gender + '\'' +
                ", customer_phoneN = '" + this.customer_phoneN + '\'' +
                ", customer_email = '" + this.customer_email + '\'' +
                ", customer_city = '" + this.customer_city + '\'' +
                ", customer_state = '" + this.customer_state + '\'' +
                ", customer_occupancy = '" + this.customer_occupancy + '\'' +
                ", customer_aFunds = '" + this.customer_aFunds +
                '}';
    }

    public void CustomerLoop(){}; // menu call to the console

    public void showAllDataCustomer(){}; // Customer's table

    public void selectTopAgeGroup(){}; // Quantitive data ordered by age group of customers

    public void Geolocation(){}; // Quantitive data about states and qty of customers in each of them

    public void determineOccupancy(){}; // customer's occupancy quantitive data

}
