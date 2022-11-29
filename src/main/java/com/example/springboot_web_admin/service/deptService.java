package com.example.springboot_web_admin.service;

import com.example.springboot_web_admin.bean.dept;
import com.example.springboot_web_admin.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class deptService {
    @Autowired
    DeptMapper deptMapper;
    public dept getDept(Integer id){
       return deptMapper.getDept(id);
    }
    public void insertDept(dept dept){
        deptMapper.insertDept(dept);
    }
}
