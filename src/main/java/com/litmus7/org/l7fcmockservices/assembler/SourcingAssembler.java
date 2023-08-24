package com.litmus7.org.l7fcmockservices.assembler;

import com.litmus7.org.l7fcmockservices.entity.Sourcing;
import com.litmus7.org.l7fcmockservices.model.SourcingRequest;

public class SourcingAssembler {
    public static Sourcing assembleSource(SourcingRequest request) {
        Sourcing source = new Sourcing();
        source.setTransactionType(request.getTransactionType().name());
        source.setSellerCode(request.getSellerCode());
        source.setEnterpriseCode(request.getEnterpriseCode());
        source.setCartId(request.getCartId());
        source.setCountry(request.getShippingAddress().getCountry().name());
        source.setZipCode(request.getShippingAddress().getZipCode());
        source.setState(request.getShippingAddress().getState());
        source.setSourceSystem(request.getSourceSystem());
        source.setSourcingId((int)Math.round(Math.random()*1000));
        return source;
    }

}
