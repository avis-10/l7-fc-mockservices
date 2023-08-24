package com.litmus7.org.l7fcmockservices.service.impl;

import com.litmus7.org.l7fcmockservices.assembler.PaymentResponseAssembler;
import com.litmus7.org.l7fcmockservices.domain.Payments;
import com.litmus7.org.l7fcmockservices.exception.PaymentValidationException;
import com.litmus7.org.l7fcmockservices.model.PaymentRequest;
import com.litmus7.org.l7fcmockservices.model.PaymentResponse;
import com.litmus7.org.l7fcmockservices.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public PaymentResponse createPayment(PaymentRequest request) {
        PaymentResponse response = new PaymentResponse();
        List<Payments> respoPayments = new ArrayList<>();
        request.getPayments().forEach(payment -> {
            if(validations(payment)) {
                Payments payments = PaymentResponseAssembler.assemblePayment(payment);
                respoPayments.add(payments);
            }
        });
        response.setCorrelation_id("");
        response.setPayments(respoPayments);
        return response;
    }

    private boolean validations(Payments payment) {
        if (payment.getAmount().getValue() < 100.0)
            return true;
        else
            throw new PaymentValidationException();
    }
}
