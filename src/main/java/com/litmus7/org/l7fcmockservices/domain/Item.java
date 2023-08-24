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
public class Item {

    @NonNull
    private String itemId;
    private String uom;
    @NonNull
    private Double requiredQuantity;
    @NonNull
    private String locationIds;
    private String lineId;
    @NonNull
    private FulfillmentType fulfillmentType;
    private String carrierServiceCode;
    private String shipNode;
    private Boolean requestedQtyAvailable;
    private Double requestedQuantity;
    private String unavailableReason;
    private Double maxShipNodeQuantity;
    private Double totalAvailableQuantity;

}
