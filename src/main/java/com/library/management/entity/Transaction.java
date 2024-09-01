package com.library.management.entity;

import jakarta.persistence.*;
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private Date checkOutDate;
    private Date returnDate;
    private Date dueDate;
    private String status;

}

