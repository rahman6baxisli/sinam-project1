package com.sinam.sinamproject.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "sender_account_id")
    private BankAccount senderAccount;
    @ManyToOne
    @JoinColumn(name = "receiver_account_id")
    private BankAccount receiverAccount;
}

