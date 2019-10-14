package com.contas.appcontas.service;

import com.contas.appcontas.model.Bill;
import com.contas.appcontas.repository.IBills;
import com.contas.appcontas.service.exception.BillAlreadyExistException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillService {

    private IBills bills;

    public  BillService(@Autowired IBills bills) {
        this.bills = bills;
    }

    public Bill save(final Bill bill){
        Optional<Bill> billByNameAndMonth = bills.findByNameAndIdMonth(bill.getName(), bill.getIdMonth());

        if(billByNameAndMonth.isPresent()){
            throw new BillAlreadyExistException();
        }

        return bills.save(bill);
    }

    public Bill edit(final Bill bill){
        return bills.save(bill);
    }

    public Bill delete(final Bill bill){
        bills.delete(bill);
        return bill;
    }
}
