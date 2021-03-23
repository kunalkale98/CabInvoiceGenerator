package com.invoice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepository {

    public Map<Integer,List<Invoice>> rideRepo = new HashMap<>();
    public List<Invoice> invoices;

    public void addInvoice(int userId,Invoice invoiceData){
        invoices = rideRepo.get(userId);
        if (invoices == null){
            invoices = new ArrayList<>();
        }
        invoices.add(invoiceData);
        rideRepo.put(userId,invoices);
    }

    public List<Invoice> getRideInvoices(int userId){
        List<Invoice> invoices = rideRepo.get(userId);
        return invoices;
    }
}
