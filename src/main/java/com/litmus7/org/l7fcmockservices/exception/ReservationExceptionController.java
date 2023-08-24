package com.litmus7.org.l7fcmockservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ReservationExceptionController {

    @ExceptionHandler(value = QuantityNotAvailableException.class)
    public ResponseEntity<Object> itemNotAvailable(QuantityNotAvailableException qtyEx) {
        return new ResponseEntity<>("Requested Item Quantity Not Available", HttpStatus.NOT_FOUND);
    }
}
