package com.atguigu.springboot.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.atguigu.springboot.Application;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.logging.Logger;

/**
 * @创建人 ym
 * @创建时间 2021/3/6 0006
 * @描述
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@AutoConfigureMockMvc
public class TestUserController {

//经过尝试证明，在这里的Loggerfactory还是没有用
//    private Logger logger = LoggerFactory.getLogger(TestUserController.class);

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void before(){
        System.out.println("单元测试开始...");
    }

    @Test
    public void test01(){
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
//                .get("user/uname/admin2"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andReturn();

//        获取测试结果响应状态
//        System.out.println(mvcResult.getResponse().getStatus());
//        获取测试结果响应内容
//        至于为什么这里又报错了，应该还是版本有变化，以前的老接口变了
//        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @After
    public void after(){
        System.out.println("单元测试结束...");
    }

}
