package com.litmus7.org.l7fcmockservices.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.litmus7.org.l7fcmockservices.domain.enums.FulfillmentType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseItem {

    private String itemId;
    private String lineId;
    private String shipNode;
    private Boolean requestedQtyAvailable;
    private Double requestedQuantity;
    private String unavailableReason;
    private Double maxShipNodeQuantity;
    private Double totalAvailableQuantity;

}
