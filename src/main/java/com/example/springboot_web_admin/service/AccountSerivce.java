package com.example.springboot_web_admin.service;

import com.example.springboot_web_admin.bean.user;
import com.example.springboot_web_admin.mapper.AccountUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountSerivce {
    @Autowired
    AccountUser accountUser;
    public user getAccountUser(Integer id){
        return accountUser.getUser(id);
    }
}
