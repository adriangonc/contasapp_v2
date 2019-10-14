package com.contas.appcontas.service.exception;

import org.springframework.http.HttpStatus;

public class BillAlreadyExistException extends BusinessException {
    public BillAlreadyExistException() {
        super("bill-error-6", HttpStatus.BAD_REQUEST);
    }
}
