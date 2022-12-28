package com.tbd.bank_backend.repositories;

import com.tbd.bank_backend.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
    List<Account> findAllAccountsByUserUserName(String userName);
}