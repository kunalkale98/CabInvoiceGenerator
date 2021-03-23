package com.invoice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceGenerator {
    enum RideType{
        Normal(10,1,5),
        Premium(15,2,20);

        private final int COST_PER_KM;
        private final int COST_PER_MIN;
        private final int MIN_FARE;

        RideType(int costPerKm, int costPerMin, int minFare){
            this.COST_PER_KM = costPerKm;
            this.COST_PER_MIN = costPerMin;
            this.MIN_FARE = minFare;
        }

    }

    public int calculateFare(int distance,int time, RideType rideType){
        int fare = Math.max(rideType.COST_PER_KM*distance + rideType.COST_PER_MIN*time , rideType.MIN_FARE);
        System.out.println("Fare: "+fare);
        return fare;
    }

    public int totalFare(List<Ride> rideList, RideType rideType){
        int totalFare = 0;
        for (Ride ride: rideList) {
            totalFare += calculateFare(ride.distance,ride.time,rideType);
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
