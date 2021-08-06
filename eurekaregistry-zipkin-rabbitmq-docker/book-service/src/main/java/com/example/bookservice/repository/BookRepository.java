package com.example.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookservice.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
