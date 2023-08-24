package com.litmus7.org.l7fcmockservices.assembler;

import com.litmus7.org.l7fcmockservices.domain.Payments;
import com.litmus7.org.l7fcmockservices.domain.Status;

public class PaymentResponseAssembler {
    public static Payments assemblePayment(Payments payment) {
        Payments payments = new Payments();
        payments.setPayment_method_ref_id(payment.getPayment_method_ref_id());
        payments.setDescription("APPROVED");
        payments.setStatus(Status.ACCEPTED);
        return payments;
    }
}
