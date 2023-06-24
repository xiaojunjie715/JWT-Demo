package com.example.jwtdemo.common;


public class RestResult<T> {
    private int code;
    private String msg;
    private T data;

    public RestResult(int code) {
        this(code, "", null);
    }
    public RestResult(int code, String msg) {
        this(code, msg, null);
    }

    public RestResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean isSuccess() {
        return this.code == 200;
    }
}