package com.example.springboot_web_admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class globalExceptionHandler {
    @ExceptionHandler({ArithmeticException.class,ClassNotFoundException.class,NoClassDefFoundError.class})
    public String hello(Exception ex){
        log.info("异常是:{}",ex.getLocalizedMessage());
        return "4xx";
    }
}
