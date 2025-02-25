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

    public static void updateRental(String oldCustomerName, String oldRentalDate, CarRental updatedRental){
        String query = "UPDATE carRental SET customerName = ?, carModel = ?, rentalDate = ?, returnDate = ?, rentalPrice = ?, totalAmount = ? WHERE customerName = ? AND rentalDate = ?";
        try (Connection conn = DatabaseConnection.getDBConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, updatedRental.getCustomerName());
            stmt.setString(2, updatedRental.getCarModel());
            stmt.setString(3, updatedRental.getrentalDate());
            stmt.setString(4, updatedRental.getreturnDate());
            stmt.setDouble(5, updatedRental.getrentalPrice());
            stmt.setDouble(6, updatedRental.getTotalAmount());
            stmt.setString(7, oldCustomerName);
            stmt.setString(8, oldRentalDate);
            stmt.executeUpdate();
            System.out.println("Car rental updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteRental(String customerName, String rentalDate){
        String query = "DELETE FROM carRental WHERE customerName = ? AND rentalDate = ?";
        try (Connection conn = DatabaseConnection.getDBConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, customerName);
            stmt.setString(2, rentalDate);
            stmt.executeUpdate();
            System.out.println("Car rental deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void searchRentalsByCarModel(String carModel){
        String query = "SELECT * FROM carRental WHERE carModel LIKE ?";
        try (Connection conn = DatabaseConnection.getDBConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, "%" + carModel + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("RentalID: " + rs.getInt("rentalID") + ", CustomerName: " + rs.getString("customerName") +
                        ", CarModel: " + rs.getString("carModel") + ", RentalDate: " + rs.getString("rentalDate") +
                        ", ReturnDate: " + rs.getString("returnDate") + ", Rental Price: " + rs.getDouble("rentalPrice") +
                        ", TotalAmount: " + rs.getDouble("totalAmount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void filterRentalsByDate(String rentalDate){
        String query = "SELECT * FROM carRental WHERE rentalDate = ?";
        try (Connection conn = DatabaseConnection.getDBConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, rentalDate);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("RentalID: " + rs.getInt("rentalID") + ", CustomerName: " + rs.getString("customerName") +
                        ", CarModel: " + rs.getString("carModel") + ", RentalDate: " + rs.getString("rentalDate") +
                        ", ReturnDate: " + rs.getString("returnDate") + ", Rental Price: " + rs.getDouble("rentalPrice") +
                        ", TotalAmount: " + rs.getDouble("totalAmount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
