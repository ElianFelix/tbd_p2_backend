package com.tbd.bank_backend.controllers;

import com.tbd.bank_backend.models.Account;
import com.tbd.bank_backend.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return aServ.saveAccount(account);
    }
}
