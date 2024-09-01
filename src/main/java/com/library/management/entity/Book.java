package com.library.management.entity;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "books")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  @ManyToMany
  @JoinTable(name = "book_authors",
          joinColumns = @JoinColumn(name = "id"),
          inverseJoinColumns = @JoinColumn(name = "author_id"))
  private List<AuthorEntity> authors;

  private String isbn;
  private String genre;
  private Date publishedDate;
  private String status;
}
