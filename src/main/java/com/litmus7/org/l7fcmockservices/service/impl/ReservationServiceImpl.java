package com.litmus7.org.l7fcmockservices.service.impl;

import com.litmus7.org.l7fcmockservices.domain.LineReservationDetails;
import com.litmus7.org.l7fcmockservices.entity.Items;
import com.litmus7.org.l7fcmockservices.entity.Reservation;
import com.litmus7.org.l7fcmockservices.exception.QuantityNotAvailableException;
import com.litmus7.org.l7fcmockservices.model.ReservationRequest;
import com.litmus7.org.l7fcmockservices.repository.ItemsRepository;
import com.litmus7.org.l7fcmockservices.repository.ReservationRepository;
import com.litmus7.org.l7fcmockservices.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepo;

    @Autowired
    private ItemsRepository itemsRepo;

    @Override
    public Boolean reservationFlag() {
        Reservation reservation = null;
        Optional<Reservation> optReserv = reservationRepo.findById(1l);
        if (optReserv.isPresent()){
            reservation = optReserv.get();
        }
        return reservation.getReservationFlag();
    }

    @Override
    public void processReservation(ReservationRequest request) {
        List<LineReservationDetails> reservationDetails = request.getLineReservationDetails();
        reservationDetails.forEach(eachReservation -> {
            Items dbItem = itemsRepo
                    .findItemsByItemIdLocIdFulfillment(
                    eachReservation.getProductId(),
                    eachReservation.getLocationId(),
                    eachReservation.getFulfillmentType().name()
                    );
            if (Objects.nonNull(dbItem)) {
                dbItem.setQuantity(dbItem.getQuantity() - eachReservation.getQuantity());
                if (dbItem.getQuantity() >= 0)
                    itemsRepo.save(dbItem);
                else {
                    throw new QuantityNotAvailableException();
                }
            }
        } );
    }

}
