package com.litmus7.org.l7fcmockservices.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.litmus7.org.l7fcmockservices.domain.PromiseDate;
import com.litmus7.org.l7fcmockservices.domain.ResponseItem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SourcingResponse {

    private Boolean available;
    private List<ResponseItem> items;
    private List<PromiseDate> promiseDates;
    private Boolean datesCalculated;

}
