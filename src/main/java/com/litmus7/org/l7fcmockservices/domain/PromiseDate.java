package com.litmus7.org.l7fcmockservices.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PromiseDate {

    private String carrierServiceCode;
    private String shipNode;
    private String dcTimeZone;
    private String shippingDate;
    private String deliveryDate;
    private Integer deliveryDateType;
    private String cutoffTimestamp;
    private Boolean delayAdded;

}
