package com.litmus7.org.l7fcmockservices.service;

import com.litmus7.org.l7fcmockservices.model.SourcingRequest;
import com.litmus7.org.l7fcmockservices.model.SourcingResponse;

public interface SourcingService {

    public SourcingResponse generateResponse(SourcingRequest request);

}
