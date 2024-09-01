package com.library.management.service;

import com.library.management.entity.AuthorEntity;
import com.library.management.entity.Book;
import com.library.management.model.BookRequest;
import com.library.management.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class BookService {
  BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public String addBook(BookRequest bookRequest) {
    Book book = new Book();

    book.setId(bookRequest.getId());
    book.setIsbn(bookRequest.getIsbn());
    book.setStatus(bookRequest.getStatus());
    book.setGenre(bookRequest.getGenre());
    List<AuthorEntity> authorList = bookRequest.getAuthors().stream()
            .map(
                    author -> {
                      AuthorEntity author1 = new AuthorEntity();
                      author1.setId(author.getId());
                      author1.setBiography(author.getBiography());
                      author1.setName(author.getName());
                      return author1;
                    })
            .collect(Collectors.toList());
    book.setAuthors(authorList);
    book.setTitle(bookRequest.getTitle());
    book.setPublishedDate(bookRequest.getPublishedDate());
    bookRepository.save(book);
    return "Successfully " + bookRequest.getTitle() + "get added to the books table";
  }
}
