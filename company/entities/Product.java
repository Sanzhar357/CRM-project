package com.company.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Product {
    private String product_id;
    private String product_category;
    private int product_name_length;
    private int product_description_length;
    private int product_photos_qty;
    private int product_weight_g;
    private int product_length_cm;
    private int product_geight_cm;
    private int product_width_cm;

    protected String connectionUrl = "jdbc:postgresql://localhost:5432/CRM DB";
    protected Connection con = null;
    protected ResultSet rs = null;
    protected Statement stmt = null;

    public Product() { }

    public Product(String product_id,String product_category,int product_name_length, int product_description_length, int product_photos_qty,
                   int product_weight_g,int product_length_cm,int product_geight_cm,int product_width_cm ){
        setProduct_id(product_id);
        setProduct_category(product_category);
        setProduct_name_length(product_name_length);
        setProduct_description_length(product_description_length);
        setProduct_photos_qty(product_photos_qty);
        setProduct_weight_g(product_weight_g);
        setProduct_length_cm(product_length_cm);
        setProduct_geight_cm(product_geight_cm);
        setProduct_width_cm(product_width_cm);
    }

    public int getProduct_description_length() {
        return product_description_length;
    }

    public int getProduct_geight_cm() {
        return product_geight_cm;
    }

    public int getProduct_length_cm() {
        return product_length_cm;
    }

    public int getProduct_name_length() {
        return product_name_length;
    }

    public String getProduct_id() {
        return product_id;
    }

    public int getProduct_photos_qty() {
        return product_photos_qty;
    }

    public String getProduct_category() {
        return product_category;
    }

    public int getProduct_weight_g() {
        return product_weight_g;
    }

    public int getProduct_width_cm() {
        return product_width_cm;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public void setProduct_description_length(int product_description_length) {
        this.product_description_length = product_description_length;
    }

    public void setProduct_length_cm(int product_length_cm) {
        this.product_length_cm = product_length_cm;
    }

    public void setProduct_geight_cm(int product_geight_cm) {
        this.product_geight_cm = product_geight_cm;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setProduct_name_length(int product_name_length) {
        this.product_name_length = product_name_length;
    }

    public void setProduct_photos_qty(int product_photos_qty) {
        this.product_photos_qty = product_photos_qty;
    }

    public void setProduct_weight_g(int product_weight_g) {
        this.product_weight_g = product_weight_g;
    }

    public void setProduct_width_cm(int product_width_cm) {
        this.product_width_cm = product_width_cm;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id='" + this.product_id + '\'' +
                ", product_category='" + this.product_category + '\'' +
                ", product_name_length=" + this.product_name_length +
                ", product_description_length=" + this.product_description_length +
                ", product_photos_qty=" + this.product_photos_qty +
                ", product_weight_g=" + this.product_weight_g +
                ", product_length_cm=" + this.product_length_cm +
                ", product_geight_cm=" + this.product_geight_cm +
                ", product_width_cm=" + this.product_width_cm +
                '}';
    }

    public void ItemLoop(){}; // menu call to the console

    public void letterOfNameDescrip(){}; // name(length) of product with its description(length)

    public void massOfProduct(){}; // shows heaviest products in catalog
    
}
