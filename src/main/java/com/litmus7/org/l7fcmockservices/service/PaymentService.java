package com.litmus7.org.l7fcmockservices.service;

import com.litmus7.org.l7fcmockservices.model.PaymentRequest;
import com.litmus7.org.l7fcmockservices.model.PaymentResponse;

public interface PaymentService {

    PaymentResponse createPayment(PaymentRequest requestBody);
}
