package com.company.entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Order_items {
    private int order_id;
    private int order_item_id;
    private String product_id ;
    private String seller_id ;
    private String shipping_limit_date;
    private int product_price ;
    private int product_cost ;
    private int freight_value;

    protected String connectionUrl = "jdbc:postgresql://localhost:5432/CRM DB";
    protected Connection con = null;
    protected ResultSet rs = null;
    protected Statement stmt = null;

    public Order_items(){

    }

    public Order_items(int order_item_id,String product_id,String seller_id,String shipping_limit_date,int product_price,int product_cost,int freight_value){
        setOrder_item_id(order_item_id);
        setProduct_id(product_id);
        setSeller_id(seller_id);
        setShipping_limit_date(shipping_limit_date);
        setProduct_price(product_price);
        setProduct_cost(product_cost);
        setFreight_value(freight_value);
    }

    public Order_items(int order_id,int order_item_id,String product_id,String seller_id,String shipping_limit_date,int product_price,int product_cost,int freight_value){
        setOrder_id(order_id);
        setOrder_item_id(order_item_id);
        setProduct_id(product_id);
        setSeller_id(seller_id);
        setShipping_limit_date(shipping_limit_date);
        setProduct_price(product_price);
        setProduct_cost(product_cost);
        setFreight_value(freight_value);
    }

    public String getProduct_id() {
        return product_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getOrder_item_id() {
        return order_item_id;
    }

    public int getProduct_cost() {
        return product_cost;
    }

    public int getFreight_value() {
        return freight_value;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public int getProduct_price() {
        return product_price;
    }

    public String getShipping_limit_date() {
        return shipping_limit_date;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setOrder_item_id(int order_item_id) {
        this.order_item_id = order_item_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public void setFreight_value(int freight_value) {
        this.freight_value = freight_value;
    }

    public void setProduct_cost(int product_cost) {
        this.product_cost = product_cost;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public void setShipping_limit_date(String shipping_limit_date) {
        this.shipping_limit_date = shipping_limit_date;
    }

    @Override
    public String toString() {
        return "Order_items{" +
                "order_id=" + this.order_id +
                ", order_item_id=" + this.order_item_id +
                ", product_id='" + this.product_id + '\'' +
                ", seller_id='" + this.seller_id + '\'' +
                ", shipping_limit_date='" + this.shipping_limit_date + '\'' +
                ", product_price=" + this.product_price +
                ", product_cost=" + this.product_cost +
                ", freight_value=" + this.freight_value +
                '}';
    }

    public void OrderItemLoop(){}; // menu call to the console

    public void top5ExpensiveProducts (){}; // top 5 the most expensive products for all the time

    public void top5CheapestProducts (){}; // top 5 the cheapest products for all the time

    public void top3ExpensiveProductsDate (){}; // top 3 the most expensive products for a certain period of time

    public void top3CheapestProductsDate(){}; // top 3 the cheapest products for a certain period of time

    public void calculateFundOfCompany(){}; // calculation of money turnover
  
}
