package com.toolsChangelle.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

import javax.persistence.Entity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BusinessError {
    private String message;
    private HttpStatus status;
}
