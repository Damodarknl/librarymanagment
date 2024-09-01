package com.library.management.entity;

import jakarta.persistence.*;
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private Date membershipDate;
    private String status;
    private String address;
}
