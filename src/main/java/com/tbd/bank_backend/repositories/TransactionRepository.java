package com.tbd.bank_backend.repositories;

import com.tbd.bank_backend.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {}
