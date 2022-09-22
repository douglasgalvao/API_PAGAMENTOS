package com.toolsChangelle.mapper;

import com.toolsChangelle.Dtos.TransactionDTO;
import com.toolsChangelle.entities.Account;
import com.toolsChangelle.entities.Transaction;

public class TransactionMapper {
    public static Transaction toModel(TransactionDTO transactionDTO, Account account) {
        return Transaction.builder()
                .account(account)
                .cartao(transactionDTO.getCartao())
                .paymentMethod(transactionDTO.getPaymentMethod())
                .description(transactionDTO.getDescription())
                .id(transactionDTO.getId())
                .build();
    }

    public static TransactionDTO toDTO(Transaction transaction,Account account) {
        return TransactionDTO.builder()
                .account(AccountMapper.toDTO(transaction.getAccount()))
                .cartao(transaction.getCartao())
                .paymentMethod(transaction.getPaymentMethod())
                .description(transaction.getDescription())
                .id(transaction.getId())
                .build();
    }
}
