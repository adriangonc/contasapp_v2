package com.contas.appcontas.service;

import com.contas.appcontas.model.Bill;
import com.contas.appcontas.service.exception.BillAlreadyExistException;
import jdk.jfr.Frequency;
import org.junit.Test;

import java.util.Date;

public class BillServiceTest {
    private BillService billService;

    @Test(expected = BillAlreadyExistException.class)
    public void should_deny_creation_of_bill_that_exists(){
        BillService billService = new BillService();
        Bill bill = new Bill();
        bill.setName("Teste");
        bill.setExpirationDate(new Date());
        //bill.setFrequency();
        bill.setValue(25);

        billService.save(bill);
    }
}
