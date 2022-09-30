package com.Payment_API.mapper;

import com.Payment_API.Dtos.AccountDTO;
import com.Payment_API.config.GenerateUUID;
import com.Payment_API.entities.Account;
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
