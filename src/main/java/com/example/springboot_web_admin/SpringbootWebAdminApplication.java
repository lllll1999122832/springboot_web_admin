package com.example.springboot_web_admin;

import com.example.springboot_web_admin.mapper.AccountUser;
import com.example.springboot_web_admin.service.AccountSerivce;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication

@ServletComponentScan(basePackages = "com.example.springboot_web_admin.servlet")
@MapperScan("")
public class SpringbootWebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebAdminApplication.class, args);
    }

}
