package com.carrental.models;

import java.sql.*;
 

public class CarRentalManager {
    
     
    public static void addRental(CarRental rental){
        String query="INSERT INTO carrental (customerName, carModel, rentalDate, returnDate, rentalPrice, totalAmount) VALUES(?,?,?,?,?,?);";
        try (Connection conn = DatabaseConnection.getDBConnection();
            PreparedStatement stmt = conn.prepareStatement(query);){
            //System.out.println("Customer Name: " + rental.getCustomerName());
            stmt.setString(1, rental.getCustomerName());
            stmt.setString(2, rental.getCarModel());
            stmt.setString(3, rental.getrentalDate());
            stmt.setString(4, rental.getreturnDate());
            stmt.setDouble(5, rental.getrentalPrice());
            stmt.setDouble(6, rental.getTotalAmount());
            stmt.executeUpdate();
            System.out.println("Car booker sucessfully!!!");
             }
         catch(SQLException e){
            e.printStackTrace();
         }
        }

    public static void displayAllRentals(){
        String query="SELECT * FROM carrental;";
        ResultSet rs=null;
        try(Connection conn=DatabaseConnection.getDBConnection();){
            Statement st=conn.createStatement();
            rs=st.executeQuery(query);
            while(rs.next()){
                System.out.println("RentalID: "+rs.getInt(1)+", Customer Name: "+rs.getString(2)+", Car Model: "+rs.getString(3)+", Rental Date: "+rs.getString(4)+", Return Date: "+rs.getString(5)+", Rental Price: "+rs.getDouble(6)+", Total Amount: "+rs.getDouble(7));
                
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        

    }

    public static void updateRental(String oldCustomerName, String oldRentalDate, CarRental updateRental){

    }

    public static void deleteRental(String customerName, String rentalDate){

    }

    public static void searchRentalsByCarModel(String carModel){

    }

    public static void filterRentalsByDate(String rentalDate){
        
    }
}
