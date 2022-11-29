package com.example.springboot_web_admin.controller;

import com.example.springboot_web_admin.bean.dept;
import com.example.springboot_web_admin.bean.user;
import com.example.springboot_web_admin.mapper.AccountUser;
import com.example.springboot_web_admin.service.AccountSerivce;
import com.example.springboot_web_admin.service.deptService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
//@Profile("test")
public class helloController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AccountSerivce accountSerivce;
    @Autowired
    deptService deptService;
    Counter counter;
    public void MyService(MeterRegistry meterRegistry){
         counter = meterRegistry.counter("count");
    }
    @ResponseBody
    @RequestMapping("/sql")
    public String sql(){
        Integer integer = jdbcTemplate.queryForObject("select count(*) from t_user ", Integer.class);
        return integer.toString();
    }
    @RequestMapping(value = {"/","/login"})
    public String hello(){
//        counter.increment();
        return "login";
    }
    @PostMapping("/login")
    public String login(user user, HttpSession session, Model model){
       if(!StringUtils.isEmpty(user.getUsername())&&user.getPassword().equals("12345")){
           session.setAttribute("user",user);
           return "redirect:main.html";
       }else{
          model.addAttribute("msg","账号密码错误");
          return "login";
       }
    }
    @RequestMapping("/main.html")
    public String main(HttpSession session){
        user user = (user)session.getAttribute("user");
//        System.out.println(1/0);
        if(user!=null)
            return "main";
        else
            return "login";
    }
    @RequestMapping("/accu")
    @ResponseBody
    public user accountUser(){
        return accountSerivce.getAccountUser(2);
    }
    @RequestMapping("/dept")
    @ResponseBody
    public dept getDept(){
        System.out.println(deptService.getDept(2));
        return null;
    }
    @RequestMapping("/deptInsert")
    public String insertDept(){
        dept lai = new dept(null, "lai");
        deptService.insertDept(lai);
        System.out.println(lai);
       return "main";
    }
}
