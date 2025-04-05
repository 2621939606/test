package com.hdcy.hdcy.exception;

import com.hdcy.hdcy.pojo.ResponseMassage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice   //统一处理，全局异常处理器
public class GlobalExceptionHandlerAdvice {


    // 全局异常处理
    @ExceptionHandler({Exception.class})
    public ResponseMassage handleException(Exception e, HttpServletRequest request, HttpServletResponse response) {
        System.out.print("异常信息--");
        System.out.println(e.getMessage());
        return new ResponseMassage(500, "error", e.getMessage());

    }
}
