package com.tbd.bank_backend.services;

import com.tbd.bank_backend.models.Account;
import com.tbd.bank_backend.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAccountsById(String username) {
        //return accountRepository.findAllAccountsByUserId(username);
        return accountRepository.findAllAccountsByUserId(username);
    }
}
