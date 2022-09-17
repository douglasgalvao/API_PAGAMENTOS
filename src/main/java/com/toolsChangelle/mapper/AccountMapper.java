package com.toolsChangelle.mapper;

import com.toolsChangelle.Dtos.AccountDTO;
import com.toolsChangelle.entities.Account;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountMapper {

    public static AccountDTO toDTO(Account account) {
        return AccountDTO.builder()
                .id(account.getId())
                .name(account.getName())
                .currentBalance(account.getCurrentBalance())
                .build();
    }

    public static Account toModel(AccountDTO accountDTO) {
        return Account.builder()
                .currentBalance(accountDTO.getCurrentBalance())
                .id(accountDTO.getId())
                .name(accountDTO.getName())
                .build();
    }



}
