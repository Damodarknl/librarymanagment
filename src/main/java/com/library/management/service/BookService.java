package com.library.management.service;

import com.library.management.entity.AuthorEntity;
import com.library.management.entity.Book;
import com.library.management.entity.DeleteBook;
import com.library.management.model.BookRequest;
import com.library.management.repository.BookRepository;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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

    //book.setId(bookRequest.getId());
    book.setIsbn(bookRequest.getIsbn());
    book.setStatus(bookRequest.getStatus());
    book.setGenre(bookRequest.getGenre());
    Set<AuthorEntity> authorList = bookRequest.getAuthors().stream()
            .map(
                    author -> {
                      AuthorEntity author1 = new AuthorEntity();
                      //author1.setId(author.getId());
                      author1.setBiography(author.getBiography());
                      author1.setName(author.getName());
                      return author1;
                    })
            .collect(Collectors.toSet());
    book.setAuthors(authorList);
    book.setTitle(bookRequest.getTitle());
    book.setPublishedDate(bookRequest.getPublishedDate());
    bookRepository.save(book);
    return "Successfully " + bookRequest.getTitle() + "get added to the books table";
  }
  public String deleteBook(DeleteBook deleteBookRequest){
      try{

          Optional<Book> bookDetails = bookRepository.findById(deleteBookRequest.getBookId());
          if(bookDetails.isPresent()){
              Book book = bookDetails.get();
              bookRepository.deleteById(deleteBookRequest.getBookId());
              System.out.println(book.getTitle()+ "The book title is");
          }else {
              return MessageFormat.format("The specified book id {0} is not present in the data base ", deleteBookRequest.getBookId());
          }
      }catch (Exception e){

      }


      return "";
  }
}
