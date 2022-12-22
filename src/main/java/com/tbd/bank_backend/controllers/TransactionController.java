package com.tbd.bank_backend.controllers;

import com.tbd.bank_backend.models.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

	@GetMapping
	public List<Transaction> getTransactions(Principal principal){
		return null;
	}

}
