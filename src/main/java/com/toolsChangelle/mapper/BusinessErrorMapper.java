package com.toolsChangelle.mapper;

import com.toolsChangelle.Dtos.AccountDTO;
import com.toolsChangelle.entities.Account;
import com.toolsChangelle.exceptions.BusinessError;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BusinessErrorMapper {
    public static BusinessError toDTO(String message, HttpStatus status) {
        return BusinessError.builder()
                .message(message)
                .status(status)
                .build();
    }

}
