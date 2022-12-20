package com.tbd.bank_backend.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    /**
     * The primary key of the account.
     */
    private int id;

    /**
     * The amount of money (in dollars) in the account.
     */
    private float balance;

    /**
     * The account type (checking or savings).
     */
    @Min(value = 1, message = "Type cannot be less than 1.")
    @Max(value = 2, message = "Type cannot be greater than 2.")
    private int type = 1;

    /**
     * The foreign key associated with the user's primary key.
     */
    @NotNull(message = "User ID cannot be null.")
    @Min(value = 1, message = "User ID cannot be less than 1.")
    private int userId;
}
