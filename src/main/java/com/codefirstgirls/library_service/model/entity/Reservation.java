package com.codefirstgirls.library_service.model.entity;

import com.codefirstgirls.library_service.model.ReservationStatus;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "reservations")
@Getter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long reservationId;

    @Column(name = "book_id", nullable = false)
    private Long bookId;

    @Enumerated(EnumType.STRING)
    @Column(name = "reservation_status", nullable = false)
    private ReservationStatus reservationStatus;

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", bookId=" + bookId +
                ", reservationStatus=" + reservationStatus +
                '}';
    }
}
