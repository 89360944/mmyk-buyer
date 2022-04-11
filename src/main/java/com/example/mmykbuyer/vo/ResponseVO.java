package com.example.mmykbuyer.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseVO<T> implements Serializable {

    private int code;

    private String msg;

    private T data;

    public static <T> ResponseVO<T> ok(Integer code) {
        ResponseVO<T> response = new ResponseVO<>();
        response.setCode(code);
        response.setMsg("");
        return response;
    }

    public static <T> ResponseVO<T> ok(Integer code, String msg) {
        ResponseVO<T> response = new ResponseVO<>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    public static <T> ResponseVO<T> ok(T data) {
        ResponseVO<T> response = new ResponseVO<>();
        response.setCode(0);
        response.setMsg("");
        response.setData(data);
        return response;
    }

    public static <T> ResponseVO<T> ok() {
        ResponseVO<T> response = new ResponseVO<>();
        response.setCode(0);
        response.setMsg("");
        return response;
    }

}
