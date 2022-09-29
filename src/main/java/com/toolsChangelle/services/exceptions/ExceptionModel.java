package com.toolsChangelle.services.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

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
