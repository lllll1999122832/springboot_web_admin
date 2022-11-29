package com.example.springboot_web_admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class formTestController {
    @RequestMapping("/form_layouts")
    public String form(){
        return "from/form_layouts";
    }
    @RequestMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos")MultipartFile[]photos) throws IOException {
        log.info("邮箱={},姓名={},头像={},生活照={}",email,username,headerImg.getSize(),photos.length);
        String path="C:\\Users\\31461\\Desktop\\";
        if(!headerImg.isEmpty()){
            headerImg.transferTo(new File(path+headerImg.getOriginalFilename()));
        }
        if(photos.length>0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()){
                    photo.transferTo(new File(path+photo.getOriginalFilename()));
                }
            }
        }
        return "main";
    }
}
