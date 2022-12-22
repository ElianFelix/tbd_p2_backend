package com.tbd.bank_backend.controllers;

import com.tbd.bank_backend.models.Transaction;
import com.tbd.bank_backend.models.TransactionStatus;
import com.tbd.bank_backend.models.TransactionType;
import com.tbd.bank_backend.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

	@Autowired
	private TransactionService tServ;

	@GetMapping
	public List<Transaction> getTransactions(Principal principal){
		return null;
	}

	@PostMapping
	public Transaction createTransaction(Transaction transaction) {
		return null;
	}

	@PostMapping("/type")
	public List<TransactionType>  createType(@RequestBody List<TransactionType> types){
		return tServ.createTTypes(types);
	}

	@PostMapping("/status")
	public List<TransactionStatus>  createStatus(@RequestBody List<TransactionStatus> statuses ){
		return tServ.createTStatuses(statuses);

	}

}
