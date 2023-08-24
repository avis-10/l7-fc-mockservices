package com.litmus7.org.l7fcmockservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.litmus7.org.l7fcmockservices.domain.enums.FulfillmentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "items")
public class Items {

    @Id
    @Column(name = "internal_id")
    private Long internalId;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "uom")
    private String uom;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "location_ids")
    private String locationIds;

    @Column(name = "fulfillment_type")
    private String fulfillmentType;

    @Column(name = "carrier_service_code")
    private String carrierServiceCode;

    @Column(name = "ship_node")
    private String shipNode;

    @Column(name = "unavailable_reason")
    private String unavailableReason;

}
