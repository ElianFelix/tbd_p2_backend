package com.tbd.bank_backend.services;

import com.tbd.bank_backend.models.Account;
import com.tbd.bank_backend.models.Transaction;
import com.tbd.bank_backend.repositories.TransactionRepository;
import com.tbd.bank_backend.repositories.TransactionStatusRepository;
import com.tbd.bank_backend.repositories.TransactionTypeRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

	@Autowired
	 private TransactionRepository transactionRepository;

	@Autowired
	private TransactionTypeRepository typeRepo;

	@Autowired
	private TransactionStatusRepository statusRepo;



	public Page<Transaction> getAllTransactions(UUID accountId, int page, int size, String filter) {
		PageRequest pr = PageRequest.of(page, size);
		return switch(filter) {
			case "Income" -> transactionRepository.findByAccountIdByAmountGreaterThanEqual(accountId, pr, 0);
			case "Expenses" -> transactionRepository.findByAccountIdByAmountLessThan(accountId, pr, 0);
			default -> transactionRepository.findAllByAccountId(accountId, pr);
		};

	}


	public Transaction saveTransaction(Transaction transaction){

		return transactionRepository.save(transaction);
	}


}
