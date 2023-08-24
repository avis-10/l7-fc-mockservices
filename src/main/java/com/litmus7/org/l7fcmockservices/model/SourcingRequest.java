package com.litmus7.org.l7fcmockservices.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.litmus7.org.l7fcmockservices.domain.Address;
import com.litmus7.org.l7fcmockservices.domain.Item;
import com.litmus7.org.l7fcmockservices.domain.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SourcingRequest {
    @NonNull
    private TransactionType transactionType;
    @NonNull
    private String sellerCode;
    @NonNull
    private String enterpriseCode;
    @NonNull
    private String sourceSystem;
    @NonNull
    private String cartId;
    private Address shippingAddress;
    @NonNull
    private List<Item> items;
}
