package com.example.springboot_web_admin.mapper;

import com.example.springboot_web_admin.bean.user;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.query.Param;

@Mapper
public interface AccountUser {
    public user getUser(Integer id);
}
