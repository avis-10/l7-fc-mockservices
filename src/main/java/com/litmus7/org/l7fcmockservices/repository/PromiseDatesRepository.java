package com.litmus7.org.l7fcmockservices.repository;

import com.litmus7.org.l7fcmockservices.entity.PromiseDates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromiseDatesRepository extends JpaRepository<PromiseDates, String> {
}
