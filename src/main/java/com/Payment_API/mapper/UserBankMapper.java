package com.Payment_API.mapper;

import com.Payment_API.Dtos.UserBankDTO;
import com.Payment_API.entities.user.UserBank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserBankMapper {
    public static UserBankDTO toDTO(UserBank user){
        return UserBankDTO.builder()
                .id(user.getId())
                .cpf(user.getCpf())
                .login(user.getLogin())
                .email(user.getEmail())
                .accountID(user.getAccountID())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
    public static UserBank toModel(UserBankDTO user){
        return UserBank.builder()
                .id(user.getId())
                .password(user.getPassword())
                .cpf(user.getCpf())
                .login(user.getLogin())
                .email(user.getEmail())
                .accountID(user.getAccountID())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

}