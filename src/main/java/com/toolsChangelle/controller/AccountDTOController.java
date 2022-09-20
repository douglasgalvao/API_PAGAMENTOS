package com.toolsChangelle.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.toolsChangelle.Dtos.AccountDTO;
import com.toolsChangelle.services.AccountService;


@RestController
@RequestMapping(value = "/accounts")
public class AccountDTOController {
    @Autowired
    private AccountService service;
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        System.out.println("Antes do erro :S");
        System.out.println(service.toString());
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

}
