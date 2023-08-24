package com.litmus7.org.l7fcmockservices.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payments {
    @NonNull
    private Amount amount;
    @NonNull
    private String payment_method_ref_id;
    @NonNull
    private String request_id;
    private String description;
    private Status status;
}
