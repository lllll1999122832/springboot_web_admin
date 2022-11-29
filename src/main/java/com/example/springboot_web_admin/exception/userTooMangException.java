package com.example.springboot_web_admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "数量太多了")
public class userTooMangException extends RuntimeException{
    public  userTooMangException(String ex){
        super(ex);
    }
    public  userTooMangException(){
    }
}
