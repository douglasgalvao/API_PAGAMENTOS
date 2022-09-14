package com.toolsChangelle.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolsChangelle.entities.Transaction;
import com.toolsChangelle.repositories.TransactionRepository;
import com.toolsChangelle.enums.StatusDescription;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository repTransaction;

	public List<Transaction> getAll() {
		List<Transaction> transactions = repTransaction.findAll();
		return transactions;
	}

	public Transaction getByID(Long id) {
		Optional<Transaction> transaction = repTransaction.findById(id);
		return transaction.get();
	}

	public Transaction save(Transaction transaction) {
		return repTransaction.save(transaction);
	}

	public Transaction changeExtorno(Long id) {
		Optional<Transaction> transaction = repTransaction.findById(id);
		if (transaction.isEmpty()) {
			return null;
		}
		transaction.get().getDescription().setStatus(StatusDescription.CANCELADO);
		save(transaction.get());
		return transaction.get();
	}

}
