package com.atguigu.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @创建人 ym
 * @创建时间 2021/3/2 0002
 * @描述主入口，所有内容的入口都经过这里
 **/
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args){
        //返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //查看容器组件
//        String[] name = run.getBeanDefinitionNames();
//        for (String item : name){
//            System.out.println(item);
//        }
    }
}
