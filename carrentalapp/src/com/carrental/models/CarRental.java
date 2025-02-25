package com.carrental.models;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class CarRental {

    private String customerName;
    private String carModel;
    private String rentalDate;
    private String returnDate;
    private double rentalPrice;
    private double totalAmount;

    public void CarRentalDetails(String customerName,String carModel,String rentalDate,String returnDate,double rentalPrice){
       //System.out.println("printing inside carrentaldetails method: "+ customerName);
       this.customerName= customerName;
       this.carModel= carModel;
       this.returnDate= returnDate;
       this.rentalDate= rentalDate;
       this.rentalPrice= rentalPrice;
    }

    public double TotalAmountCalc(){
        LocalDate startDate= LocalDate.parse(rentalDate);
        LocalDate endDate= LocalDate.parse(returnDate);
        
        long rentalDays=ChronoUnit.DAYS.between(startDate, endDate);
        this.totalAmount=(double)rentalDays*rentalPrice;
        return totalAmount;
    }

    public String getCustomerName(){
        //System.out.println("printing cutomer name inside carrental class in getcustomer method: "+ customerName);
        return customerName;
    }
    public String getCarModel(){
        return carModel;
    }
    public String getrentalDate(){
        return rentalDate;
    }
    public String getreturnDate(){
        return returnDate;
    }
    public double getrentalPrice(){
        return rentalPrice;
    }
    public double getTotalAmount(){
        return TotalAmountCalc();
    }

}
