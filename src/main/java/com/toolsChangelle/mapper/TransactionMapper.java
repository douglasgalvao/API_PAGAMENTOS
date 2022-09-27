package com.toolsChangelle.mapper;

import com.toolsChangelle.Dtos.TransactionDTO;
import com.toolsChangelle.entities.Account;
import com.toolsChangelle.entities.Transaction;

public class TransactionMapper {
    public static Transaction toModel(TransactionDTO transactionDTO) {
        return Transaction.builder()
                .paymentMethod(transactionDTO.getPaymentMethod())
                .accountID(transactionDTO.getAccountID())
                .description(transactionDTO.getDescription())
                .id(transactionDTO.getId())
                .build();
    }

    public static TransactionDTO toDTO(Transaction transaction) {
        return TransactionDTO.builder()
                .paymentMethod(transaction.getPaymentMethod())
                .accountID(transaction.getAccountID())
                .description(transaction.getDescription())
                .id(transaction.getId())
                .build();
    }
}
