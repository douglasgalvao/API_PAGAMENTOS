package com.Payment_API.controller;

import com.Payment_API.Dtos.AccountDTO;
import com.Payment_API.Dtos.TransactionDTO;
import com.Payment_API.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @PostMapping
    @ResponseBody
    public ResponseEntity<TransactionDTO> saveTransaction(@RequestBody TransactionDTO transactionDTO){

        return ResponseEntity.ok(transactionService.saveTransaction(transactionDTO));
    }

    @GetMapping(value="/{id}")
    @ResponseBody
    public ResponseEntity<List<TransactionDTO>> getAllTransactionsByAccountId(@PathVariable UUID id){
        return ResponseEntity.ok(transactionService.getAllTransactionsById(id));
    }


    @GetMapping
    @ResponseBody
    public ResponseEntity<List<TransactionDTO>> getAllTransactions(){
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }


}
