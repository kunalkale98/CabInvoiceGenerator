package com.invoice;

import java.util.List;

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


}
