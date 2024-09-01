package com.library.management.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Author {
    private Long id;
    private String name;
    private String biography;
}
