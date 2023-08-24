package com.litmus7.org.l7fcmockservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PaymentExceptionController {

    @ExceptionHandler(value = PaymentValidationException.class)
    public ResponseEntity<Object> amountException(PaymentValidationException amountEx) {
        return new ResponseEntity<>("Requested amount for the payment is invalid", HttpStatus.BAD_REQUEST);
    }
}
