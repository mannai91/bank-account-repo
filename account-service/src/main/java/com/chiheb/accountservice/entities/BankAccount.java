package com.chiheb.accountservice.entities;

import com.chiheb.accountservice.enums.AccountType;
import com.chiheb.accountservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString @Builder
@Table(name="BankAccount")
public class BankAccount {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double balance;
    private String currency;
    @Column(name = "created_Date")
    private LocalDate createdDate;
    private Long customerId;
    @Enumerated(EnumType.STRING)// enum.string :pour enregitrer l'enum comme string
                                // dans la base de donnee
    private AccountType type;
    @Transient //ignore cette attribut la: c'est un attribut
                // qui existe dans la class mais que n'est
                // pas representer  dans la base de donnee.
    private Customer customer;
}
