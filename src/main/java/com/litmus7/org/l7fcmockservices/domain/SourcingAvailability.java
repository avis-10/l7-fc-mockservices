package com.litmus7.org.l7fcmockservices.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SourcingAvailability {
    private List<Item> itemsInDbWithQty;
    private List<Item> itemsInDbWithoutQty;
    private List<Item> itemsNotInDb;
    private String itemAvailability;
}
