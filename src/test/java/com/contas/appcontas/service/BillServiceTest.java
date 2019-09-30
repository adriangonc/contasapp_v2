package com.contas.appcontas.service;

import com.contas.appcontas.model.Bill;
import com.contas.appcontas.model.BillFrequencyEnum;
import com.contas.appcontas.service.exception.BillAlreadyExistException;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class BillServiceTest {
    private BillService billService;

    @Before
    public void setup(){
        billService = new BillService();
    }

    @Test(expected = BillAlreadyExistException.class)
    public void testDenyCreationOfBillThatExistsShouldException(){
        Bill bill = new Bill();
        bill.setName("Teste");
        bill.setExpirationDate(new Date());
        bill.setFrequency(BillFrequencyEnum.EVENTUAL);
        bill.setValue(25);

        billService.save(bill);
    }

    @Test
    public void testCreateNewBillShoultTrue(){
        Bill bill = new Bill();
        bill.setName("Teste");
        bill.setExpirationDate(new Date());
        bill.setFrequency(BillFrequencyEnum.EVENTUAL);
        bill.setValue(25);

        Bill savedBill = billService.save(bill);

        assertThat(savedBill.getId(), greaterThan(0L));
        assertThat(savedBill.getName(),  equalTo("Teste"));
    }
}
