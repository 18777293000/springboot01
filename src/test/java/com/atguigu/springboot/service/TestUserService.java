package com.atguigu.springboot.service;

import com.atguigu.springboot.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.logging.Logger;

/**
 * @创建人 ym
 * @创建时间 2021/3/6 0006
 * @描述
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class TestUserService {

//    private Logger log = LoggerFactory.getLogger(TestUserService.class);
//    因为版本问题，这个junit插件好像有哪里语法不太对，反正暂时用不起来，下面的log对象的方法也不起作用
//    但是整个单元测试的主要内容还是可以跑起来的
//    private Logger logger = LoggerFactory.getLogger(TestUserService.class);

    @Resource
    private UserService userService;

    @Before
    public void before(){
//        log.info("单元测试开始...");
        System.out.println("单元测试开始...");
    }

    @Test
    public void test01(){
//        log.info("用户记录：｛｝", userService.queryUserById(30));
        System.out.println(userService.queryUserById(30));
    }

    @Test
    public void test02(){
        System.out.println(userService.queryUserByName("admin2"));
    }


    @After
    public void after(){
//        log.info("单元测试结束...");
        System.out.println("单元测试结束...");
    }

}
