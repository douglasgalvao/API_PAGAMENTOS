package com.toolsChangelle.mapper;

import com.toolsChangelle.Dtos.AccountDTO;
import com.toolsChangelle.entities.Account;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountMapper {

    public static AccountDTO toDTO(Account account) {
        return AccountDTO.builder()
                .id(account.getId())
                .currentBalance(account.getBalance())
                .build();
    }

    public static Account toModel(AccountDTO accountDTO) {
        return Account.builder()
                .balance(accountDTO.getCurrentBalance())
                .id(accountDTO.getId())
                .build();
    }



}
