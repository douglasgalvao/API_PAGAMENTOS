package com.toolsChangelle.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException{
    private HttpStatus status;
    public BusinessException(String message){
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
    };

}
