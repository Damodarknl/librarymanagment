package com.library.management.controller;

import com.library.management.model.BookRequest;
import com.library.management.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("library/bookservice")
public class Book {
  BookService bookService;

  public Book(BookService bookService) {
    this.bookService = bookService;
  }

  @PostMapping(value = "/addbook", consumes = "application/json")
  public ResponseEntity<String> addNewBook(@Valid @RequestBody BookRequest bookRequest) {
    String response = bookService.addBook(bookRequest);
    return ResponseEntity.ok("Successfully book added");
  }
}
