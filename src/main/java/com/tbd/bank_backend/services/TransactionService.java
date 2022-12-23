package com.tbd.bank_backend.services;

import com.tbd.bank_backend.models.Transaction;
import com.tbd.bank_backend.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

	@Autowired
	 private TransactionRepository transactionRepository;


	public List<Transaction> getallTransactions() {
		return transactionRepository.findAll();
	}


}
