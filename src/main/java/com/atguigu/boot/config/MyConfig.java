package com.atguigu.boot.config;

import com.atguigu.boot.com.atguigu.boot.bean.Pet;
import com.atguigu.boot.com.atguigu.boot.bean.User;
import com.atguigu.boot.com.atguigu.boot.bean.Car;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @创建人 ym
 * @创建时间 2021/3/3 0003
 * @描述
 **/
//conditionalonbean这个条件注解语句放在这里，则是对整个配置类的加载做判断
//@ImportResource("classpath:beans.xml")//引入使用xml的配置文件进行容器注入
@Configuration(proxyBeanMethods = false)
//@EnableConfigurationProperties(Car.class)
public class MyConfig {

    /*
    * 条件注解，特定条件才执行*/
    @ConditionalOnBean(name = "tomcatPet") //容器中有pet组件的时候，才加载user组件
    @Bean
    public User user01(){
        return new User("enze",18);
    }

    @Bean
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }
}
