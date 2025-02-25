package com.carrental.models;

import java.util.Scanner;

public class App {
     
    public static void main (String[] args){
       // DatabaseConnection db1=new DatabaseConnection();
        DatabaseConnection.getDBConnection();
        CarRental rental = new CarRental();
        //CarRentalManager c1=new CarRentalManager();
        System.out.println("Welcome to car rental services!!!");
        System.out.println("Choose an option for what you are looking for...");
        System.out.println("1.Add Rental");
        System.out.println("2.Display Rental");
        System.out.println("3.Update Rental");
        System.out.println("4.Delete Rental");
        System.out.println("5.Search Rental by Car Model");
        System.out.println("6.Filter Rental by Date");

        Scanner sc=new Scanner(System.in);
        int response=sc.nextInt();
        sc.nextLine();


        switch(response){
            case 1:  
            System.out.print("Enter the Customer Name: ");
            String CustomerName = sc.nextLine();

            //System.out.println("Customer Name: " + CustomerName);  // Add this to check if the input is being received

            
            System.out.print("Enter the Car Model: ");
            String CarModel = sc.nextLine();
            
            System.out.print("Enter the Rental Date: ");
            String rentalDate = sc.nextLine();
            
            System.out.print("Enter the Return Date: ");
            String returnDate = sc.nextLine();
            
            System.out.print("Enter the Rental Price: ");
            double rentalPrice = sc.nextDouble();
            sc.nextLine();

                rental.CarRentalDetails(CustomerName,CarModel,rentalDate,returnDate,rentalPrice);
                CarRentalManager.addRental(rental);
                break;
            
            case 2:
                System.out.println("Displaying all the details...");
                CarRentalManager.displayAllRentals();
            
        }

        sc.close();
        
        


    }
}
