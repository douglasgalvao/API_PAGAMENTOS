package com.Payment_API.services;

import com.Payment_API.Dtos.AccountDTO;
import com.Payment_API.Dtos.TransactionDTO;
import com.Payment_API.entities.Account;
import com.Payment_API.entities.Transaction;
import com.Payment_API.enums.StatusDescription;
import com.Payment_API.mapper.AccountMapper;
import com.Payment_API.mapper.TransactionMapper;
import com.Payment_API.repositories.AccountRepository;
import com.Payment_API.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public List<TransactionDTO> getAllTransactions() {
        List<Transaction> transaction = transactionRepository.findAll();
        return transaction.stream().map(TransactionMapper::toDTO).collect(Collectors.toList());
    }
    @Transactional
    public List<TransactionDTO> getAllTransactionsByAccountId(UUID accountId) {
        List<Transaction> transactions = transactionRepository.findAllById(Collections.singleton(accountId));
        return transactions.stream().map(TransactionMapper::toDTO).collect(Collectors.toList());
    }

    @Transactional
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

    @Transactional
    public AccountDTO depositBalance(AccountDTO accountDTO) {
        Account account = accountRepository.findById(accountDTO.getId()).orElseThrow(EntityNotFoundException::new);
        account.setBalance(accountDTO.getBalance() + account.getBalance());
        return AccountMapper.toDTO(accountRepository.save(account));
    }


}
