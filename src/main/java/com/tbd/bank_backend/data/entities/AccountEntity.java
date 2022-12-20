package com.tbd.bank_backend.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class AccountEntity {

    /**
     * The primary key of the account.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * The amount of money (in dollars) in the account.
     */
    @Column(name = "balance")
    private float balance;

    /**
     * The account type (checking or savings).
     */
    @Column(name = "type")
    private int type; // TODO: include foreign key annotation

    /**
     * The foreign key associated with the user's primary key.
     */
    @Column(name = "user_id")
    private int userId; // TODO: include foreign key annotation

}
