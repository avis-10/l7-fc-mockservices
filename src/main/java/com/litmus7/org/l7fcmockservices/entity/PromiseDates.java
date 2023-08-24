package com.litmus7.org.l7fcmockservices.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "promise_dates")
public class PromiseDates {

    @Column(name = "carrier_service_code")
    private String carrierServiceCode;

    @Id
    @Column(name = "ship_node")
    private String shipNode;

    @Column(name = "dc_time_zone")
    private String dcTimeZone;

    @Column(name = "shipping_date")
    private Date shippingDate;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "delivery_date_type")
    private Integer deliveryDateType;

    @Column(name = "cutoff_timestamp")
    private Date cutoffTimestamp;

    @Column(name = "delay_added")
    private String delayAdded;
}
