package com.toolsChangelle.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.toolsChangelle.mapper.AccountMapper;
import com.toolsChangelle.services.exceptions.ExceptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolsChangelle.Dtos.AccountDTO;
import com.toolsChangelle.entities.Account;
import com.toolsChangelle.repositories.AccountRepository;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;


@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<AccountDTO> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(AccountMapper::toDTO).collect(Collectors.toList());
    }
    public AccountDTO getAccountByID(UUID id) {
        Account account = accountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return AccountMapper.toDTO(account);
    }

    public AccountDTO saveAccount(AccountDTO accountdto) {
        Account account = AccountMapper.toModel(accountdto);
        accountRepository.save(account);
        return AccountMapper.toDTO(account);
    }


    public void deleteAccount(UUID id) {
        Optional<Account> account = accountRepository.findById(id);
        accountRepository.deleteById(id);
    }


}
