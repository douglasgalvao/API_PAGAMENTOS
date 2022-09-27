package com.toolsChangelle.services;

import com.toolsChangelle.Dtos.AccountDTO;
import com.toolsChangelle.Dtos.TransactionDTO;
import com.toolsChangelle.entities.Account;
import com.toolsChangelle.entities.Transaction;
import com.toolsChangelle.enums.StatusDescription;
import com.toolsChangelle.mapper.AccountMapper;
import com.toolsChangelle.mapper.TransactionMapper;
import com.toolsChangelle.repositories.AccountRepository;
import com.toolsChangelle.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;

    public List<TransactionDTO> getAllTransactions() {
        List<Transaction> transaction = transactionRepository.findAll();
        return transaction.stream().map(TransactionMapper::toDTO).collect(Collectors.toList());
    }

    public TransactionDTO saveTransaction(TransactionDTO transactionDTO) {
        Optional<Account> account = accountRepository.findById(transactionDTO.getAccountID());
        if (account.isPresent() && account.get().getBalance() >= parseDouble(transactionDTO.getDescription().getValor())) {
            account.get().setBalance(account.get().getBalance() - parseDouble(transactionDTO.getDescription().getValor()));
            transactionDTO.getDescription().setStatus(StatusDescription.AUTORIZADO);
            return TransactionMapper.toDTO(transactionRepository.save(TransactionMapper.toModel(transactionDTO)));
        }
        transactionDTO.getDescription().setStatus(StatusDescription.CANCELADO);
        return TransactionMapper.toDTO(TransactionMapper.toModel(transactionDTO));
    }


    public AccountDTO depositBalance(AccountDTO accountDTO) {
        Optional<Account> account = accountRepository.findById(accountDTO.getId());
        if (account.isPresent()) {
            account.get().setBalance(accountDTO.getBalance() + account.get().getBalance());
            return AccountMapper.toDTO(accountRepository.save(account.get()));
        }
        Account nullResult = AccountMapper.toModel(accountDTO);
        return AccountMapper.toDTO(nullResult);
    }


}
