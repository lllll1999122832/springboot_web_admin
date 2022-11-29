package com.example.springboot_web_admin.config;

import com.example.springboot_web_admin.interceptor.LoginInterceptor;
import com.example.springboot_web_admin.interceptor.RedisCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import redis.clients.jedis.Jedis;

@Configuration
public class webAdminConfig implements WebMvcConfigurer {
    @Autowired
    RedisCountInterceptor redisCountInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**/","/sql");
        registry.addInterceptor(redisCountInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**/","/sql");
    }
    @Bean
    public Jedis getJedis(){
        return new Jedis("192.168.200.128",6379);
    }

}
