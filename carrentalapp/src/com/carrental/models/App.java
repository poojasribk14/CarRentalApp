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
        System.out.println("7.Exit");
        System.out.println("Choose an option: ");

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
                break;

            case 3:
                System.out.println("Enter your already given name: ");
                String OldcustomerName=sc.nextLine();

                System.out.println("Enter your existing rental booking date: ");
                String OldrentalDate=sc.nextLine();

                System.out.println("Enter the new customer name: ");
                String newCustomerName=sc.nextLine();

                System.out.println("Enter the new car model name: ");
                String newCarModel=sc.nextLine();

                System.out.println("Enter the new rental date: ");
                String newRentalDate=sc.nextLine();
 
                System.out.println("Enter the new return date: ");
                String newReturnDate=sc.nextLine();

                System.out.println("Enter the new rental price: ");
                double newRentalPrice=sc.nextDouble();

                sc.nextLine();
                
                CarRental updateCarRental=new CarRental();
                updateCarRental.CarRentalDetails(newCustomerName, newCarModel, newRentalDate, newReturnDate, newRentalPrice);
                CarRentalManager.updateRental(OldcustomerName, OldrentalDate, updateCarRental);
                break;
            
            case 4:
                System.out.println("Enter the customer name that you want to delete: ");
                String customerName=sc.nextLine();

                System.out.println("Enter the rental date that you want to delete: ");
                String rentaldate=sc.nextLine();

                CarRentalManager.deleteRental(customerName,rentaldate);
                break;
            
            case 5:
                System.out.println("Enter the Car Model you want to search: ");
                String carModel=sc.nextLine();
                CarRentalManager.searchRentalsByCarModel(carModel);
                break;

            case 6:
                System.out.println("Enter the date from which you want to filter it out: ");
                String rentaldates=sc.nextLine();
                CarRentalManager.filterRentalsByDate(rentaldates);
                break;

            case 7:
                System.out.println("Exiting Application...");
                sc.close();

            default:
                System.out.println("Invalid option!!!");
            
                              
        }

         
        
        


    }
}
