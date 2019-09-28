package com.contas.appcontas.service;

import com.contas.appcontas.model.Bill;
import com.contas.appcontas.service.exception.BillAlreadyExistException;

public class BillService {
    public void save(Bill bill){
        throw new BillAlreadyExistException();
    }
}
