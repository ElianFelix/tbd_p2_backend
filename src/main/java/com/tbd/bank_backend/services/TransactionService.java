package com.tbd.bank_backend.services;

import com.tbd.bank_backend.models.Transaction;
import com.tbd.bank_backend.models.TransactionStatus;
import com.tbd.bank_backend.models.TransactionType;
import com.tbd.bank_backend.repositories.TransactionRepository;
import com.tbd.bank_backend.repositories.TransactionStatusRepository;
import com.tbd.bank_backend.repositories.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

	@Autowired
	 private TransactionRepository transactionRepository;

	@Autowired
	private TransactionStatusRepository transactionStatusRepository;

	@Autowired
	private TransactionTypeRepository transactionTypeRepository;

	public List<TransactionType> createTTypes(List<TransactionType>  types){
		return transactionTypeRepository.saveAll(types);
	}

	public List<TransactionStatus> createTStatuses(List<TransactionStatus> statuses){
		return transactionStatusRepository.saveAll(statuses);
	}

}
