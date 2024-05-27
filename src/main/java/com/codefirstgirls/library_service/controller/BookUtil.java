package com.codefirstgirls.library_service.controller;

import com.codefirstgirls.library_service.model.ReservationStatus;
import com.codefirstgirls.library_service.model.entity.Book;
import com.codefirstgirls.library_service.model.entity.Reservation;
import com.codefirstgirls.library_service.model.repository.BookRepository;
import com.codefirstgirls.library_service.model.repository.ReservationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

import static com.codefirstgirls.library_service.model.ReservationStatus.AVAILABLE;
import static com.codefirstgirls.library_service.model.ReservationStatus.RESERVED;

@Controller
@Slf4j
public class BookUtil {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public List<String> getAllBookNames(){
        return getBookNamesFromBookList(bookRepository.findAll());
    }

    public List<String> getBooksByReservation(boolean reserved){
        ReservationStatus reservationStatus = reserved ? RESERVED : AVAILABLE;
        List<Reservation> reservations = reservationRepository.findByReservationStatus(reservationStatus);
        log.info("reservations found with status: " + reservationStatus.toString() + " "  + reservations.size());

        List<Book> booksWithStatus = new java.util.ArrayList<>(List.of());
        for(Reservation reservation : reservations){
            Optional<Book> bookFound = bookRepository.findById(reservation.getBookId());
            booksWithStatus.add(bookFound.get());
        }

        return getBookNamesFromBookList(booksWithStatus);
    }

    public List<String> getBookNamesFromBookList(List<Book> books){ // this is only public for testing early on, without using mocking
        List<String> bookNames = new java.util.ArrayList<>(List.of());
        for(Book book : books){
            bookNames.add(book.getBookName());
        }
        return bookNames;
    }
}
