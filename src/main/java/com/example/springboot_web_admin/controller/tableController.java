package com.example.springboot_web_admin.controller;

import com.example.springboot_web_admin.bean.user;
import com.example.springboot_web_admin.exception.userTooMangException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;

@Controller
public class tableController {
    @RequestMapping("/basic_table")
    public String basic(){
        return "table/basic_table";
    }
    @RequestMapping("/editable_table")
    public String editable(){
        return "table/editable_table";
    }
    @RequestMapping("/pricing_table")
    public String pricing(){
        return "table/pricing_table";
    }
    @RequestMapping("/responsive_table")
    public String responsive(){
        return "table/responsive_table";
    }
    @RequestMapping("/dynamic_table")
    public String dynamic(){
        List<user>users=new ArrayList<>();
        users.add(new user());
        users.add(new user());
//        if(users.size()>=1) {
//            throw new userTooMangException();
//        }
        return "table/dynamic_table";
    }
}
