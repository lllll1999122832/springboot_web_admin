package com.example.springboot_web_admin.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.imageio.spi.RegisterableService;
import javax.servlet.ServletRegistration;
import java.util.Arrays;

@Configuration(proxyBeanMethods = true)
//@EnableWebMvc
public class MyRegisConfig {
    @Bean
    public ServletRegistrationBean myServlet(){
        myServlet myServlet = new myServlet();
        return new ServletRegistrationBean(myServlet,"/my","/my02");
    }
    @Bean
    public FilterRegistrationBean myFilter(){
        myfilter myfilter = new myfilter();
//        return new FilterRegistrationBean(myfilter,myServlet());
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myfilter);
        filterRegistrationBean.addUrlPatterns(String.valueOf(Arrays.asList("/a","/b")));
        return filterRegistrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean mylistener(){
        return new ServletListenerRegistrationBean(new mylistener());
    }
}
