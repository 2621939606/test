package com.hdcy.hdcy.pojo;

import org.springframework.http.HttpStatus;

public class ResponseMassage<T> {

    private Integer code;
    private String message;
    private T data;
    public ResponseMassage(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    //请求成功
    public static <T>ResponseMassage<T> success(T data) {
        System.out.print("这是响应返回-->");
        System.out.println(data);
        return new ResponseMassage(HttpStatus.OK.value(), "success", data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
