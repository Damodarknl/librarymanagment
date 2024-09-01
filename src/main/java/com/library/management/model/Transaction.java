package com.library.management.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Setter
@Getter
@AllArgsConstructor
public class Transaction {
    private Long id;
    private Long bookId;
    private Long memberId;
    private Date checkOutDate;
    private Date returnDate;
    private Date dueDate;
    private String status;
}
