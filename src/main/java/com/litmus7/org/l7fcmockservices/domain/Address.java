package com.litmus7.org.l7fcmockservices.domain;

import com.litmus7.org.l7fcmockservices.domain.enums.Country;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Address {
    private Country country;
    private String zipCode;
    private String state;
}
