package com.example.springboot_web_admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloJava {
    @RequestMapping("/hello")
    public String hello(){
        return "this is java";
    }

}
