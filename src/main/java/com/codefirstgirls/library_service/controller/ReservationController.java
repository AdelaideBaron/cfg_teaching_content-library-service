package com.codefirstgirls.library_service.controller;

import com.codefirstgirls.library_service.model.ReservationStatus;
import com.codefirstgirls.library_service.model.response.AllBooks;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ReservationController {

    @Autowired
    private BookUtil bookUtil;

    @GetMapping("/all_books")
    @ResponseBody
    public AllBooks getAllBooks(){
        log.info("Retrieving all books");
        List<String> allBooks = bookUtil.getAllBookNames();
        return AllBooks.builder().allBooks(allBooks).build();
    }

    @GetMapping("/unreserved_books")
    @ResponseBody
    public AllBooks getUnreservedBooks(){
        log.info("Retrieving available books");
        List<String> allBooks = bookUtil.getBooksByReservation(false);
        return AllBooks.builder().allBooks(allBooks).reservationStatus(ReservationStatus.AVAILABLE).build();
    }

    @GetMapping("/reserved_books")
    @ResponseBody
    public AllBooks getReservedBooks(){
        log.info("Retrieving reserved books");
        List<String> allBooks = bookUtil.getBooksByReservation(true);
        return AllBooks.builder().allBooks(allBooks).reservationStatus(ReservationStatus.RESERVED).build();
    }
}
