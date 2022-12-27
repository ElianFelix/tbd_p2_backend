package com.tbd.bank_backend.controllers;

import com.tbd.bank_backend.models.Account;
import com.tbd.bank_backend.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService aServ;

    @GetMapping
    public List<Account> getAccounts(Principal principal) {
        return aServ.getAccountsById(principal.getName());
    }
}
