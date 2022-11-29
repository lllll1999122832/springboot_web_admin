package com.example.springboot_web_admin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class user implements Serializable {
    Integer id;
    String username;
    String password;
    Integer age;
    String gender;
    String email;
}
