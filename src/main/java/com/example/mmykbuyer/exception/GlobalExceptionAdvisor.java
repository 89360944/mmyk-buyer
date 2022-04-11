package com.example.mmykbuyer.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvisor {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Map<String, Object> errorHandler(MethodArgumentNotValidException ex) {
        StringBuilder errorMsg = new StringBuilder();
        BindingResult re = ex.getBindingResult();
        for (ObjectError error : re.getAllErrors()) {
            errorMsg.append(error.getDefaultMessage()).append(",");
        }
        errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", -1);
        map.put("msg", errorMsg.toString());
        return map;
    }

    @ExceptionHandler(value = MyException.class)
    public Map<String, Object> errorHandler(MyException ex) {
        log.warn("MyException:{} {}", ex.getCode(), ex.getMessage());
        Map<String, Object> map = new HashMap<>();
        map.put("code", ex.getCode());
        map.put("msg", ex.getMessage());
        return map;
    }

}
