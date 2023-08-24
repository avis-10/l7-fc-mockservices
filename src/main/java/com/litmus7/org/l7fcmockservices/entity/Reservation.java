package com.litmus7.org.l7fcmockservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @Column(name = "reservation_id")
    private Long reservationId;

    @Column(name = "reservation_flag")
    private Boolean reservationFlag;
}
