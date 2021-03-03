package com.atguigu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @创建人 ym
 * @创建时间 2021/3/3 0003
 * @描述
 **/
@SpringBootApplication
public class Application {
    public static void main(String[] arge){
         ConfigurableApplicationContext run = SpringApplication.run(Application.class, arge);
    }
}
