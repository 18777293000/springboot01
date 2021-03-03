package com.atguigu.boot.config;

import com.atguigu.boot.com.atguigu.boot.bean.Pet;
import com.atguigu.boot.com.atguigu.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @创建人 ym
 * @创建时间 2021/3/3 0003
 * @描述
 **/
@Configuration
public class MyConfig {

    @Bean
    public User user01(){
        return new User("enze",18);
    }

    @Bean
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }
}
