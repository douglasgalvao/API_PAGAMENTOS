package com.toolsChangelle.mapper;

import com.toolsChangelle.Dtos.UserBankDTO;
import com.toolsChangelle.entities.UserBank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class UserBankMapper {
    public static UserBankDTO toDTO(UserBank user){
        return UserBankDTO.builder()
                .id(user.getId())
                .cpf(user.getCpf())
                .idade(user.getIdade())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
    public static UserBank toModel(UserBankDTO user){
        return UserBank.builder()
                .id(user.getId())
                .cpf(user.getCpf())
                .idade(user.getIdade())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}