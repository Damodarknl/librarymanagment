package com.library.management.model;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Member {
    private Long id;
    private String name;
    private String email;
    private Date membershipDate;
    private String status;
}
