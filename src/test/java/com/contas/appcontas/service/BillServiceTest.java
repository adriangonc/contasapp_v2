package com.contas.appcontas.service;

import com.contas.appcontas.model.Bill;
import com.contas.appcontas.model.BillFrequencyEnum;
import com.contas.appcontas.repository.IBills;
import com.contas.appcontas.service.exception.BillAlreadyExistException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.mockito.Mockito.when;
import java.util.Date;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class BillServiceTest {
    private BillService billService;

    @Mock
    private IBills billsMocked;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks( this);
        billService = new BillService(billsMocked);
    }

    @Test(expected = BillAlreadyExistException.class)
    public void testDenyCreationOfBillThatExistsShouldException(){
        Bill billInDataBase = new Bill();
        billInDataBase.setName("Teste");
        billInDataBase.setExpirationDate(new Date());
        billInDataBase.setFrequency(BillFrequencyEnum.EVENTUAL);
        billInDataBase.setValue(25);

        when(billsMocked.findByNameAndIdMonth( "Teste", 1)).thenReturn(Optional.of(billInDataBase));

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

        Bill newBillInDataBase = new Bill();
        newBillInDataBase.setId(1532L);
        newBillInDataBase.setName("Teste");
        newBillInDataBase.setExpirationDate(new Date());
        newBillInDataBase.setFrequency(BillFrequencyEnum.EVENTUAL);
        newBillInDataBase.setValue(25);
        when(billsMocked.save(bill)).thenReturn(newBillInDataBase);

        Bill savedBill = billService.save(bill);

        assertThat(savedBill.getId(), equalTo(1532L));
        assertThat(savedBill.getName(),  equalTo("Teste"));
    }
}
