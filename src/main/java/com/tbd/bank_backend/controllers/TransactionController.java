package com.tbd.bank_backend.controllers;

import com.tbd.bank_backend.models.Account;
import com.tbd.bank_backend.models.Transaction;
import com.tbd.bank_backend.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

	@Autowired
	private TransactionService tServ;

	@GetMapping
	public Page<Transaction> getTransactions(@PathVariable UUID accountId, @RequestParam int page,
	                                         @RequestParam int size, @RequestParam(defaultValue = "potatoes") String filter) {

		return tServ.getAllTransactions(accountId, page, size, filter);
	}

	@PostMapping
	public Transaction createTransaction(@RequestBody Transaction transaction) {
		return tServ.saveTransaction(transaction);
	}

}
