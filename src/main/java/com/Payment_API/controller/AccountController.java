package com.Payment_API.controller;

import java.util.List;
import java.util.UUID;

import com.Payment_API.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Payment_API.Dtos.AccountDTO;
import com.Payment_API.services.AccountService;


@RestController
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    TransactionService transactionService;
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        List<AccountDTO> list = accountService.getAllAccounts();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<AccountDTO> getAccountByID(@PathVariable UUID id) {
		return ResponseEntity.ok(accountService.getAccountByID(id));
	}
//
    @PostMapping
    @ResponseBody
    public ResponseEntity<AccountDTO> saveAccountDTO(@RequestBody AccountDTO account) {
        return ResponseEntity.ok(accountService.saveAccount(account));
    }


    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<UUID> deleteAccount(@PathVariable UUID id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok(id);
    }

    @PostMapping(value = "/deposit")
    @ResponseBody
    public ResponseEntity<AccountDTO> depositBalance(@RequestBody AccountDTO account)  {
        return ResponseEntity.ok(transactionService.depositBalance(account));
    }

    @PostMapping(value = "/withdraw")
    @ResponseBody
    public ResponseEntity<AccountDTO> withdrawBalance(@RequestBody AccountDTO account)  {
        return ResponseEntity.ok(transactionService.withdrawBalance(account));
    }

}
