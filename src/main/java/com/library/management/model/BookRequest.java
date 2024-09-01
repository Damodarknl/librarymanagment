package com.library.management.model;

import java.sql.Date;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookRequest {
  @NotNull(message = "ID cannot be null")
  private Long id;

  @NotEmpty(message = "the title should not be empty")
  private String title;

  @NotNull(message = "Authors cannot be null")
  private List<Author> authors;

  private String isbn;

  @NotEmpty(message = "the genre should not be empty")
  private String genre;

    @NotNull(message = "Published date cannot be null")
  private Date publishedDate;

  @NotEmpty(message = "the status should not be empty")
  private String status;
}
