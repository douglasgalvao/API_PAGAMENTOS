package com.toolsChangelle.Dtos;

import com.toolsChangelle.entities.Account;
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
    private String email;
    private String idade;
    private UUID accountID;
}