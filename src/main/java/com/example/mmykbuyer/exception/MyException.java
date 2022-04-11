package com.example.mmykbuyer.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MyException extends RuntimeException {

    private Integer code = -1;

    public MyException(String message) {
        super(message);
    }
    public MyException(String message, Integer code) {
        super(message);
        this.code = code;
    }

}
