package com.invoice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceGenerator {
    private static final int COST_PER_KM = 10;
    private static final int COST_PER_MIN = 1;
    private static final int MIN_FARE = 5;

    public int calculateFare(int distance,int time){
        int fare = Math.max(COST_PER_KM*distance + COST_PER_MIN*time , MIN_FARE);
        System.out.println("Fare: "+fare);
        return fare;
    }

    public int totalFare(List<Ride> rideList){
        int totalFare = 0;
        for (Ride ride: rideList) {
            totalFare += calculateFare(ride.distance,ride.time);
        }
        System.out.println("Total Fare: "+totalFare);
        return totalFare;
    }

    public int getTotalRides(List<Ride> rideList){
        int rides = rideList.size();
        System.out.println("No of Rides: "+rides);
        return rides;
    }

    public float averageFare(int totalFare,int rides){
        float avgFare = totalFare/rides;
        System.out.println("Average Fare Per Ride: "+avgFare);
        return avgFare;
    }

    public Invoice invoiceData(int noOfRides,int totalFare,int avgFare){
        Invoice invoiceData = new Invoice(noOfRides,totalFare,avgFare);
        return invoiceData;
    }
}
