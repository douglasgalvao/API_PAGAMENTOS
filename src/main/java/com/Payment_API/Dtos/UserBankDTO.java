package com.Payment_API.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserBankDTO {
    private UUID id;
    private String phoneNumber;
    private String cpf;
    private String login;
    private String senha;
    private String email;
    private UUID accountID;
}