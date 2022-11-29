package com.example.springboot_web_admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisController {
    @Resource
    RedisTemplate<String,Object> redisTemplate;
    @RequestMapping("/redis")
    public String redisHello(){
        redisTemplate.opsForValue().set("username","liulili");
        return (String) redisTemplate.opsForValue().get("username");
    }
}
