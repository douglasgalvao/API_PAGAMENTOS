package com.toolsChangelle.controller;

import com.toolsChangelle.Dtos.AccountDTO;
import com.toolsChangelle.Dtos.TransactionDTO;
import com.toolsChangelle.mapper.TransactionMapper;
import com.toolsChangelle.services.AccountService;
import com.toolsChangelle.services.TransactionService;
import org.hibernate.Transaction;
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

    @PostMapping(value = "/deposit")
    @ResponseBody
    public ResponseEntity<AccountDTO> depositBalance(@RequestBody AccountDTO account) {
        return ResponseEntity.ok(transactionService.depositBalance(account));
    }


    @GetMapping
    @ResponseBody
    public ResponseEntity<List<TransactionDTO>> getAllTransactions(){
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }


}
