package com.toolsChangelle.mapper;

import com.toolsChangelle.Dtos.UserBankDTO;
import com.toolsChangelle.config.GenerateUUID;
import com.toolsChangelle.entities.Account;
import com.toolsChangelle.entities.UserBank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
public class UserBankMapper {
    public static UserBankDTO toDTO(UserBank user){
        return UserBankDTO.builder()
                .id(user.getId())
                .cpf(user.getCpf())
                .idade(user.getIdade())
                .email(user.getEmail())
                .accountID(user.getAccountID())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
    public static UserBank toModel(UserBankDTO user){
        return UserBank.builder()
                .id(user.getId())
                .cpf(user.getCpf())
                .idade(user.getIdade())
                .email(user.getEmail())
                .accountID(user.getAccountID())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

}