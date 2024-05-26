package com.sinam.sinamproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank_accounts")
@Getter
@Setter
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status = "DEACTIVE";
    private Double balance = 300.0;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "senderAccount", cascade = CascadeType.ALL)
    private List<Transfer> sentTransfers;
    @OneToMany(mappedBy = "receiverAccount", cascade = CascadeType.ALL)
    private List<Transfer> receivedTransfers;
}

