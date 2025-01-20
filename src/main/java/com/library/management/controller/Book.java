package com.library.management.controller;

import com.library.management.entity.DeleteBook;
import com.library.management.model.BookRequest;
import com.library.management.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping(value = "/deletebook", consumes = "application/json")
  public ResponseEntity<String> deleteBook(@Valid @RequestBody DeleteBook deleteBookRequest){
    String deleteBookResponse = bookService.deleteBook(deleteBookRequest);
    return ResponseEntity.ok(deleteBookResponse);
  }
}
