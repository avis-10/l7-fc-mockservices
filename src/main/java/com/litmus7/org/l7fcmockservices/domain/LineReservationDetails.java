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
public class LineReservationDetails {
    @NonNull
    private String uom;
    @NonNull
    private Double quantity;
    @NonNull
    private String productId;
    @NonNull
    private String locationId;
    private String lineId;
    @NonNull
    private FulfillmentType fulfillmentType;
}
