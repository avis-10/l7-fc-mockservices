package com.litmus7.org.l7fcmockservices.controller;

import com.litmus7.org.l7fcmockservices.model.ReservationRequest;
import com.litmus7.org.l7fcmockservices.service.ReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(description = "Controller that exposes REST APIs for managing the Reservation service calls")
@RequestMapping("/rps/admin")
@RestController
public class ReservationController {

    @Autowired
    private ReservationService service;

    @GetMapping(value = "/reservation/{id}")
    public ResponseEntity<Object> getDetails(@PathVariable("id") String id) {
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping(value = "/reservation", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${ReservationController.generateReservationInfo.ApiOperation.value}",
            notes = "${ReservationController.generateReservationInfo.ApiOperation.notes}")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK") })
    public ResponseEntity<Object> create(@RequestBody ReservationRequest requestBody) {

//        validation(requestBody);  // return 400 if validation fails
        service.processReservation(requestBody);

        if (service.reservationFlag())
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
