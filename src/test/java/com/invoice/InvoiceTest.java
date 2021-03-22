package com.invoice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InvoiceTest {
    InvoiceGenerator invoice;
    public List<Ride> rideList;
    Ride ride1 = new Ride(10,15);
    Ride ride2 = new Ride(5,10);
    Ride ride3 = new Ride(7,12);

    @Before
    public void setup(){
        invoice = new InvoiceGenerator();
        rideList = new ArrayList<>();
        rideList.add(ride1);
        rideList.add(ride2);
        rideList.add(ride3);
    }

    @Test
    public void givenData_ToCalculateFare_ShouldReturnFare() {
        int fare = invoice.calculateFare(ride1.distance,ride1.time);
        Assert.assertEquals(fare,120);
    }

    @Test
    public void givenData_ToFindTotalFare_ShouldReturnTotalFare() {
        int totalFare = invoice.totalFare(rideList);
        Assert.assertEquals(257,totalFare);
    }

    @Test
    public void givenData_ToGetAverageFarePerRide_ShouldReturnAvg(){
        int totalFare = invoice.totalFare(rideList);
        int noOfRides = invoice.getTotalRides(rideList);
        int avgFare = (int) invoice.averageFare(totalFare,noOfRides);
        Assert.assertEquals(85,avgFare);
    }
}
