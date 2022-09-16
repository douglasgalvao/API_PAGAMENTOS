package com.toolsChangelle.controller;

import java.util.List;

import com.toolsChangelle.Dtos.TransactionDTO;
import com.toolsChangelle.entities.Transaction;
import com.toolsChangelle.services.TransactionService;
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


@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {
    @Autowired
    private TransactionService service;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<TransactionDTO>> findAllTransactionDTOs() {
        List<TransactionDTO> list = service.getAllTransactions();

        return ResponseEntity.ok(list);
    }
//
//	@GetMapping(value = "/{id}")
//	@ResponseBody
//	public ResponseEntity<TransactionDTO> getTransactionDTOByID(@PathVariable Long id) {
//		return ResponseEntity.ok(service.getTransactionDTOByID(id));
//	}
//
	@PostMapping
	@ResponseBody
	public ResponseEntity<TransactionDTO> saveTransactionDTO(@RequestBody TransactionDTO transaction) {
		return ResponseEntity.ok(service.saveTransaction(transaction));
	}

	@GetMapping(value= "/{id}")
	@ResponseBody
	public ResponseEntity<List<TransactionDTO>> getTransactionsByID(@PathVariable Long id) {
		return ResponseEntity.ok(service.getTransactionsByID(id));
	}

}
