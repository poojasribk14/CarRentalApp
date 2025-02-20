package com.carrental.models;

public class App {
     
    public static void main (String[] args){
        
        CarRentalManager CRM1=new CarRentalManager();
        DatabaseConnection db1=new DatabaseConnection();
        db1.getDBConnection();
    }
}
