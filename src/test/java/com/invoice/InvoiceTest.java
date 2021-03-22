package com.invoice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceTest {
    InvoiceGenerator invoice;
    Ride ride1 = new Ride(10,15);

    @Before
    public void setup(){
        invoice = new InvoiceGenerator();
    }

    @Test
    public void givenData_ToFindTotalFare_ShouldReturnFare() {
        int totalFare = invoice.calculateFare(ride1.distance,ride1.time);
        Assert.assertEquals(totalFare,120);
    }
}
