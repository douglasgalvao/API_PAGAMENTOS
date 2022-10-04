package com.Payment_API.controller;

import com.Payment_API.Dtos.AccountDTO;
import com.Payment_API.Dtos.TransactionDTO;
import com.Payment_API.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<TransactionDTO>> getAllTransactions(){
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }


}
