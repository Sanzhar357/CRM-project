package com.company.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Orders {
    private int customer_ID;
    private String order_status;
    private String order_purchase_timestamp;
    private String order_approved_at;
    private String order_delivered_carrier_date;
    private String order_delivered_customer_date;
    private String order_estimated_delivery_date;

    protected String connectionUrl = "jdbc:postgresql://localhost:5432/CRM DB";
    protected Connection con = null;
    protected ResultSet rs = null;
    protected Statement stmt = null;

    public Orders() {

    }

    public Orders(int customer_ID, String order_status, String order_purchase_timestamp, String order_approved_at, String order_delivered_carrier_date, String order_delivered_customer_date, String order_estimated_delivery_date) {
        setCustomer_ID(customer_ID);
        setOrder_status(order_status);
        setOrder_purchase_timestamp(order_purchase_timestamp);
        setOrder_approved_at(order_approved_at);
        setOrder_delivered_carrier_date(order_delivered_carrier_date);
        setOrder_delivered_customer_date(order_delivered_customer_date);
        setOrder_estimated_delivery_date(order_estimated_delivery_date);
    }

    public int getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        this.customer_ID = customer_ID;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getOrder_purchase_timestamp() {
        return order_purchase_timestamp;
    }

    public void setOrder_purchase_timestamp(String order_purchase_timestamp) {
        this.order_purchase_timestamp = order_purchase_timestamp;
    }

    public String getOrder_approved_at() {
        return order_approved_at;
    }

    public void setOrder_approved_at(String order_approved_at) {
        this.order_approved_at = order_approved_at;
    }

    public String getOrder_delivered_carrier_date() {
        return order_delivered_carrier_date;
    }

    public void setOrder_delivered_carrier_date(String order_delivered_carrier_date) {
        this.order_delivered_carrier_date = order_delivered_carrier_date;
    }

    public String getOrder_delivered_customer_date() {
        return order_delivered_customer_date;
    }

    public void setOrder_delivered_customer_date(String order_delivered_customer_date) {
        this.order_delivered_customer_date = order_delivered_customer_date;
    }

    public String getOrder_estimated_delivery_date() {
        return order_estimated_delivery_date;
    }

    public void setOrder_estimated_delivery_date(String order_estimated_delivery_date) {
        this.order_estimated_delivery_date = order_estimated_delivery_date;
    }

    public void OrderLoop(){}; // menu call to the consoe

    public void findActiveCustomers(){}; // list of active customers sorted by frequency of purchases

    public void showOrderStatus(){}; // quantitive data about order's status

    public void showLateDelivered(){}; // quantitive data of late delivery with date comparison

}
