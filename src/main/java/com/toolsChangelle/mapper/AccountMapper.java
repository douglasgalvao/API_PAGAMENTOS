package com.toolsChangelle.mapper;

import com.toolsChangelle.Dtos.AccountDTO;
import com.toolsChangelle.Dtos.UserBankDTO;
import com.toolsChangelle.config.GenerateUUID;
import com.toolsChangelle.entities.Account;
import com.toolsChangelle.entities.UserBank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountMapper {

    public static AccountDTO toDTO(Account account) {

        return AccountDTO.builder()
                .id(account.getId())
                .userID(account.getUserID())
                .currentBalance(account.getBalance())
                .build();
    }

    public static Account toModel(AccountDTO accountDTO) {
        return Account.builder()
                .balance(accountDTO.getCurrentBalance())
                .id(GenerateUUID.generateUuid())
                .userID(accountDTO.getUserID())
                .build();
    }



}
