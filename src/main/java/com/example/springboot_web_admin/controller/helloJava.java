package com.example.springboot_web_admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloJava {
    @RequestMapping("/hello")
    public String hello(){
        return "this is java";
    }
    @RequestMapping("/java")
    public String java(){
        return "this is hello";
    }
    @RequestMapping("/xaiomi")
    public String xaiomi(){
        return "this is Mi 13 series";
    }
    @RequestMapping("/huawei")
    public String huawei(){
        return "you must buy huawei phone!";
    }

}
