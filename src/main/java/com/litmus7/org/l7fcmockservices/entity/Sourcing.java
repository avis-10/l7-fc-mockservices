package com.litmus7.org.l7fcmockservices.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "sourcing")
public class Sourcing {

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "seller_code")
    private String sellerCode;

    @Column(name = "enterprise_code")
    private String enterpriseCode;

    @Column(name = "cart_id")
    private String cartId;

    @Column(name = "country")
    private String country;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "state")
    private String state;

    @Column(name = "source_system")
    private String sourceSystem;

    @Id
    @Column(name = "sourcing_id")
    private Integer sourcingId;

}
