package com.litmus7.org.l7fcmockservices.controller;

import com.litmus7.org.l7fcmockservices.model.PaymentRequest;
import com.litmus7.org.l7fcmockservices.model.PaymentResponse;
import com.litmus7.org.l7fcmockservices.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Api(description = "Controller that exposes REST APIs for managing the Payment service calls")
@RequestMapping("/rps/admin")
@RestController
public class PaymentController {

    @Autowired
    PaymentService service;

    @PostMapping(value = "/payment", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${PaymentController.generatePaymentInfo.ApiOperation.value}",
            notes = "${PaymentController.generatePaymentInfo.ApiOperation.notes}")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK") })
    public ResponseEntity<PaymentResponse> createPayment(@RequestBody PaymentRequest requestBody) {

        PaymentResponse response = service.createPayment(requestBody);
        response.setCorrelation_id(UUID.randomUUID().toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
//        HttpHeaders headers = ResponseEntity.status(HttpStatus.OK).body(response).getHeaders();
//        return null;
    }
}
