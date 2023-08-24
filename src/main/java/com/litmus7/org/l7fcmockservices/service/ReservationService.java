package com.litmus7.org.l7fcmockservices.service;

import com.litmus7.org.l7fcmockservices.model.ReservationRequest;

public interface ReservationService {

    Boolean reservationFlag();

    void processReservation(ReservationRequest request);
}
