package com.toolsChangelle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.toolsChangelle.entities.Transaction;
import com.toolsChangelle.services.TransactionService;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {
	@Autowired
	private TransactionService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Transaction>> findAllTransactions() {
		List<Transaction> list = service.getAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<Transaction> getTransactionByID(@PathVariable Long id) {
		System.out.println("id========="+id);
		return ResponseEntity.ok(service.getByID(id));
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction transaction) {
		System.out.println(transaction.toString());
		return ResponseEntity.ok(service.save(transaction));
	}
	
	@PatchMapping(value= "/refunded/{transactionId}")
	@ResponseBody
	public ResponseEntity<Transaction> saveRefunded(@PathVariable Long transactionId) {
		
		return ResponseEntity.ok(service.changeExtorno(transactionId));
	}

}
