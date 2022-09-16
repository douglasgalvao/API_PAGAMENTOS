package com.toolsChangelle.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.toolsChangelle.Dtos.TransactionDTO;
import com.toolsChangelle.exceptions.BusinessException;
import com.toolsChangelle.mapper.AccountMapper;
import com.toolsChangelle.mapper.TransactionMapper;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.toolsChangelle.entities.Account;
import com.toolsChangelle.entities.Transaction;
import com.toolsChangelle.enums.StatusDescription;
import com.toolsChangelle.repositories.AccountRepository;
import com.toolsChangelle.repositories.TransactionRepository;

import static java.lang.Double.parseDouble;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repTransaction;
    @Autowired
    private AccountRepository repAccount;

    public List<TransactionDTO> getAllTransactions() {
//        throw new RuntimeException("RunTime Exception");
        List<Transaction> transactions = repTransaction.findAll();
        return transactions.stream()
                .map(transaction -> TransactionMapper.toDTO(transaction))
                .collect(Collectors.toList());
    }

    public List<TransactionDTO> getTransactionsByID(Long id) {
        List<TransactionDTO> transactions = getAllTransactions();
        Account account = repAccount.findById(id).get();
        return transactions.stream().filter(transaction-> account.getId() == transaction.getAccount().getId()).collect(Collectors.toList());
    }

    public TransactionDTO saveTransaction(TransactionDTO transactionDTO) {
        Account account = repAccount.findById(transactionDTO.getAccount().getId()).get();
        if (account.getBalance() < parseDouble(transactionDTO.getDescription().getValor())) {
            Transaction response =  TransactionMapper.toModel(transactionDTO,account);
            response.getDescription().setStatus(StatusDescription.CANCELADO);
            repTransaction.save(response);
            return TransactionMapper.toDTO(response);
//            throw new BusinessException("Not enough balance to complete the transaction!");
        }
        transactionDTO.getDescription().setStatus(StatusDescription.AUTORIZADO);
        account.setBalance(account.getBalance() - parseDouble(transactionDTO.getDescription().getValor()));
        Transaction transaction = TransactionMapper.toModel(transactionDTO, account);
        repTransaction.save(transaction);
        return TransactionMapper.toDTO(transaction);
    }


}
