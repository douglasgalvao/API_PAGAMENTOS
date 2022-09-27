package com.toolsChangelle.mapper;

import com.toolsChangelle.Dtos.AccountDTO;
import com.toolsChangelle.config.GenerateUUID;
import com.toolsChangelle.entities.Account;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountMapper {

    public static AccountDTO toDTO(Account account) {

        return AccountDTO.builder()
                .id(account.getId())
                .userID(account.getUserID())
                .balance(account.getBalance())
                .build();
    }

    public static Account toModel(AccountDTO accountDTO) {
        return Account.builder()
                .balance(accountDTO.getBalance())
                .id(GenerateUUID.generateUuid())
                .userID(accountDTO.getUserID())
                .build();
    }
    


}
