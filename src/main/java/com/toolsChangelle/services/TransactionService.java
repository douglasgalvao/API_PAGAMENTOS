package com.toolsChangelle.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.toolsChangelle.Dtos.TransactionDTO;
import com.toolsChangelle.entities.BalanceDescription;
import com.toolsChangelle.mapper.TransactionMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<TransactionDTO> getTransactionsByID(UUID id) {
        List<TransactionDTO> transactions = getAllTransactions();
        Account account = repAccount.findById(id).get();
        return transactions.stream().filter(transaction-> account.getId() == transaction.getAccount().getId()).collect(Collectors.toList());
    }

    public TransactionDTO saveTransaction(@NotNull TransactionDTO transactionDTO) {


        Account account = repAccount.findById(transactionDTO.getAccount().getId()).get();
        if (account.getCurrentBalance() < parseDouble(transactionDTO.getDescription().getValor())) {
            Transaction response =  TransactionMapper.toModel(transactionDTO,account);
            response.getDescription().setStatus(StatusDescription.CANCELADO);
            repTransaction.save(response);
            return TransactionMapper.toDTO(response);
//            throw new BusinessException("Not enough balance to complete the transaction!");
        }

        transactionDTO.getDescription().setStatus(StatusDescription.AUTORIZADO);
        String valorAntesDaTransaction = account.getCurrentBalance().toString();
        account.setCurrentBalance(account.getCurrentBalance() - parseDouble(transactionDTO.getDescription().getValor()));

        Transaction transaction = TransactionMapper.toModel(transactionDTO, account);
        transaction.getDescription().setBalance(new BalanceDescription());
        transaction.getDescription().getBalance().setBalanceAntesDaTransacao(valorAntesDaTransaction);
        transaction.getDescription().getBalance().setBalanceDepoisDaTransacao(account.getCurrentBalance().toString());
        repTransaction.save(transaction);
        return TransactionMapper.toDTO(transaction);
    }


}
