package com.invoice;

public class InvoiceGenerator {
    public int calculateFare(int distance,int time){
        int minimumFare = 5;
        int totalFare = 10*distance + time + minimumFare;
        System.out.println("Total Fare: "+totalFare);
        return totalFare;
    }
}
