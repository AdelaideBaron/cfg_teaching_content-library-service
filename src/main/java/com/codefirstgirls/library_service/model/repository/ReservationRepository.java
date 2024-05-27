package com.codefirstgirls.library_service.model.repository;

import com.codefirstgirls.library_service.model.ReservationStatus;
import com.codefirstgirls.library_service.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByReservationStatus(ReservationStatus reservationStatus);

}
