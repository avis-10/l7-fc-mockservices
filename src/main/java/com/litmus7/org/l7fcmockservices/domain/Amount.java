package com.litmus7.org.l7fcmockservices.domain;

import com.litmus7.org.l7fcmockservices.domain.enums.Currency;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
public class Amount {
    @NonNull
    private Currency currency;
    @NonNull
    private Double value;
}
