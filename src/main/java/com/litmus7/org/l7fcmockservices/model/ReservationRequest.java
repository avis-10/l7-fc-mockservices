package com.litmus7.org.l7fcmockservices.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.litmus7.org.l7fcmockservices.domain.LineReservationDetails;
import com.litmus7.org.l7fcmockservices.domain.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationRequest {
    @NonNull
    private TransactionType transactionType;
    @NonNull
    private List<LineReservationDetails> lineReservationDetails;
    @NonNull
    private String reservationId;
    private String requestOrigin;
    private Boolean ignoreAvailabilityCheck;
    private String sellingChannel;
    private Date reservationRequestTime;
    private String updateUser;
}
