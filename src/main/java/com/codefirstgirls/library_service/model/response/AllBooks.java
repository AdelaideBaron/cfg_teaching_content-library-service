package com.codefirstgirls.library_service.model.response;

import com.codefirstgirls.library_service.model.ReservationStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public class AllBooks {
    @JsonProperty("status")
    ReservationStatus reservationStatus;

    @JsonProperty("all_books")
    List<String> allBooks;

}
