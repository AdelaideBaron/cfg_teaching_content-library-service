package com.codefirstgirls.library_service.model.repository;

import com.codefirstgirls.library_service.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}