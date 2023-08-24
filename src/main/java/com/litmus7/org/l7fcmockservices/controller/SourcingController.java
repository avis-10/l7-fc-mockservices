package com.litmus7.org.l7fcmockservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.litmus7.org.l7fcmockservices.model.SourcingRequest;
import com.litmus7.org.l7fcmockservices.model.SourcingResponse;
import com.litmus7.org.l7fcmockservices.service.SourcingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(description = "Controller that exposes REST APIs for managing the sourcing service calls")
@RequestMapping("/rps/admin")
@RestController
public class SourcingController {

    @Autowired
    private SourcingService sourcingService;

    @GetMapping(value = "/sourcing/{id}")
    public ResponseEntity<Object> getDetails(@PathVariable("id") String id) {
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping(value = "/sourcing", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "${SourcingController.generateSourcingInfo.ApiOperation.value}",
            notes = "${SourcingController.generateSourcingInfo.ApiOperation.notes}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK") })
    public ResponseEntity<SourcingResponse> generateSourcingInfo(@RequestBody SourcingRequest requestBody) {

        SourcingResponse response = sourcingService.generateResponse(requestBody);
        return new ResponseEntity<SourcingResponse> (response, HttpStatus.CREATED);
    }
}
