package com.invoice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InvoiceTest {
    InvoiceGenerator invoice;
    RideRepository rideRepository;
    List<Ride> rideList1;
    List<Ride> rideList2;

    @Before
    public void setup(){
        invoice = new InvoiceGenerator();
        rideList1 = new ArrayList<>();
        rideList1.add(new Ride(10,15));
        rideList1.add(new Ride(5,10));

        rideList2 = new ArrayList<>();
        rideList2.add(new Ride(7,12));
        rideList2.add(new Ride(9,10));
    }

    @Test
    public void givenData_ToCalculateFare_ShouldReturnFare() {
        int distance = 10;
        int time = 15;
        int fare = invoice.calculateFare(distance,time,InvoiceGenerator.RideType.Normal);
        Assert.assertEquals(fare,115);
    }

    @Test
    public void givenData_ToFindTotalFare_ShouldReturnTotalFare() {
        int totalFare = invoice.totalFare(rideList1,InvoiceGenerator.RideType.Normal);
        Assert.assertEquals(175,totalFare);
    }

    @Test
    public void givenData_ToGetAverageFarePerRide_ShouldReturnAvg(){
        int totalFare = invoice.totalFare(rideList1, InvoiceGenerator.RideType.Normal);
        int noOfRides = invoice.getTotalRides(rideList1);
        int avgFare = (int) invoice.averageFare(totalFare,noOfRides);
        Assert.assertEquals(87,avgFare);
    }

    @Test
    public void givenUserId_ToGetListOfRides_ShouldReturnTrue() {
        rideRepository = new RideRepository();
        List<Invoice> expectedInvoice = new ArrayList<>();
        int userId = 1;
        int totalFare = invoice.totalFare(rideList1, InvoiceGenerator.RideType.Normal);
        int noOfRides = invoice.getTotalRides(rideList1);
        int avgFare = (int) invoice.averageFare(totalFare,noOfRides);
        Invoice data = invoice.invoiceData(noOfRides,totalFare,avgFare);
        expectedInvoice.add(data);
        rideRepository.addInvoice(userId,data);

        totalFare = invoice.totalFare(rideList2, InvoiceGenerator.RideType.Normal);
        noOfRides = invoice.getTotalRides(rideList2);
        avgFare = (int) invoice.averageFare(totalFare,noOfRides);
        data = invoice.invoiceData(noOfRides,totalFare,avgFare);
        expectedInvoice.add(data);
        rideRepository.addInvoice(userId,data);
        List<Invoice> result = rideRepository.getRideInvoices(1);
        Assert.assertEquals(expectedInvoice,result);
    }

    @Test
    public void givenData_ToCheckBothPremiumAndNormalRide_ShouldReturnRideList() {
        rideRepository = new RideRepository();
        List<Invoice> expectedInvoice = new ArrayList<>();
        int userId = 1;
        int totalFare = invoice.totalFare(rideList1, InvoiceGenerator.RideType.Normal);
        int noOfRides = invoice.getTotalRides(rideList1);
        int avgFare = (int) invoice.averageFare(totalFare,noOfRides);
        Invoice data = invoice.invoiceData(noOfRides,totalFare,avgFare);
        expectedInvoice.add(data);
        rideRepository.addInvoice(userId,data);

        totalFare = invoice.totalFare(rideList2, InvoiceGenerator.RideType.Premium);
        noOfRides = invoice.getTotalRides(rideList2);
        avgFare = (int) invoice.averageFare(totalFare,noOfRides);
        data = invoice.invoiceData(noOfRides,totalFare,avgFare);
        expectedInvoice.add(data);
        rideRepository.addInvoice(userId,data);
        List<Invoice> result = rideRepository.getRideInvoices(1);
        Assert.assertEquals(expectedInvoice,result);
    }


}
