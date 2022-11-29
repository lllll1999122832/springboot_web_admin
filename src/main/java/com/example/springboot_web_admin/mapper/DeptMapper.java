package com.example.springboot_web_admin.mapper;

import com.example.springboot_web_admin.bean.dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.relational.core.sql.In;

@Mapper
public interface DeptMapper {
    @Select("select * from t_dept where dept_id=#{id}")
//    select * from t_user where id=#{id}
    public dept getDept(Integer id);
    public void insertDept(dept dept);
}
