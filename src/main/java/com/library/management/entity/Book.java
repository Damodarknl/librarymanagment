package com.library.management.entity;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

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

  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
  @JoinTable(name = "book_authors",
          joinColumns = @JoinColumn(name = "id"),
          inverseJoinColumns = @JoinColumn(name = "author_id"))
  private Set<AuthorEntity> authors;

  private String isbn;
  private String genre;
  private Date publishedDate;
  private String status;
}
