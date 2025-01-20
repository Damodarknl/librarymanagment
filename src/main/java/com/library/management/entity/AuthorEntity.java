package com.library.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "authors")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String biography;

    @ManyToMany(fetch = FetchType.LAZY, cascade ={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "authors")
    private Set<Book> books = new HashSet<>();
}
