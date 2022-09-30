package com.Payment_API.services.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExceptionModel extends RuntimeException{
    private String message;
    private Long timestamp;
    private int status;
    public ExceptionModel(String message,Long timestamp,int status){
        super(message);
        this.message = message;
        this.timestamp=timestamp;
        this.status=status;
    }

}
