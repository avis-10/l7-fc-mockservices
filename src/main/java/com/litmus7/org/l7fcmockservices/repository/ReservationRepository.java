package com.litmus7.org.l7fcmockservices.repository;

import com.litmus7.org.l7fcmockservices.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
