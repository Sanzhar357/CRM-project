package com.company.controllers.interfaces;

import java.sql.DriverManager;
import java.util.Scanner;

public interface IСustomerController {
    public void CustomerLoop();

    public void showAllDataCustomer();

    public void selectTopAgeGroup();

    public void Geolocation();

    public void determineOccupancy();
}
