package com.Payment_API.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.Payment_API.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Payment_API.Dtos.AccountDTO;
import com.Payment_API.entities.account.Account;
import com.Payment_API.repositories.AccountRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;


@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Transactional
    public List<AccountDTO> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(AccountMapper::toDTO).collect(Collectors.toList());
    }
    public AccountDTO getAccountByID(UUID id) {
        Account account = accountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return AccountMapper.toDTO(account);
    }
    @Transactional
    public AccountDTO saveAccount(AccountDTO accountdto) {
        Account account = AccountMapper.toModel(accountdto);
        accountRepository.save(account);
        return AccountMapper.toDTO(account);
    }

    @Transactional
    public void deleteAccount(UUID id) {
        Optional<Account> account = accountRepository.findById(id);
        accountRepository.deleteById(id);
    }


}
