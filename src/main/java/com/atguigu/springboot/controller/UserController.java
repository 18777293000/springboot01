package com.atguigu.springboot.controller;

import com.atguigu.springboot.service.UserService;
import com.atguigu.springboot.vo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @创建人 ym
 * @创建时间 2021/3/4 0004
 * @描述
 **/
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("user/{userName}")
    public User queryUserByUserName( @PathVariable("userName") String userName ){
        return userService.queryUserByName(userName);
    }
}
