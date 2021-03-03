package com.atguigu.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @创建人 ym
 * @创建时间 2021/3/2 0002
 * @描述
 **/
//@Controller
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String handle01(){
        return "springboot start";
    }
}
