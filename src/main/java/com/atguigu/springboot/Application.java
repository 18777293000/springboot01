package com.atguigu.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @创建人 ym
 * @创建时间 2021/3/3 0003
 * @描述
 **/
@SpringBootApplication
//自定义扫描包路径
@MapperScan("com.atguigu.springboot.dao")
//开启缓存应用
//不知道啥猫病，已开启缓存就报错，先不开了，这个教程有点东西对不上
//@EnableCaching
public class Application {
    public static void main(String[] arge){
         ConfigurableApplicationContext run = SpringApplication.run(Application.class, arge);
    }
}
