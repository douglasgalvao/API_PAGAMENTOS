package com.toolsChangelle.controller;

import java.util.List;
import java.util.UUID;

import com.toolsChangelle.entities.UserBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.toolsChangelle.Dtos.AccountDTO;
import com.toolsChangelle.services.AccountService;


@RestController
@RequestMapping(value = "/accounts")
public class AccountController {
    @Autowired
    private AccountService service;
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        List<AccountDTO> list = service.getAllAccounts();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<AccountDTO> getAccountByID(@PathVariable UUID id) {
		return ResponseEntity.ok(service.getAccountByID(id));
	}
//
    @PostMapping
    @ResponseBody
    public ResponseEntity<AccountDTO> saveAccountDTO(@RequestBody AccountDTO account) {
        return ResponseEntity.ok(service.saveAccount(account));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<UUID> deleteAccount(@PathVariable UUID id){
        service.deleteAccount(id);
        return ResponseEntity.ok(id);
    }

}
