package com.tbd.bank_backend.data;

import com.tbd.bank_backend.models.TransactionStatus;
import com.tbd.bank_backend.models.TransactionType;
import com.tbd.bank_backend.repositories.TransactionStatusRepository;
import com.tbd.bank_backend.repositories.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NormalInitializer implements CommandLineRunner {
	@Autowired
	private TransactionStatusRepository statRepo;

	@Autowired
	private TransactionTypeRepository typeRepo;


	@Override
	public void run(String... args) throws Exception {

		//create list of default types to add to db
		List<TransactionType> types = new ArrayList<>();
		types.add(new TransactionType(0, "Debit"));
		types.add(new TransactionType(0, "Credit"));
		types.add(new TransactionType(0, "Check"));
		types.add(new TransactionType(0, "Paypal"));
		types.add(new TransactionType(0, "Other"));

		typeRepo.saveAll(types);

		//create list of default statuses
		List<TransactionStatus> statuses = new ArrayList<>();
		statuses.add(new TransactionStatus(0, "Pending"));
		statuses.add(new TransactionStatus(0, "Complete"));

		statRepo.saveAll(statuses);


	}
}
