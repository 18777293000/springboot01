package com.atguigu.springboot.service;

import com.atguigu.springboot.dao.UserDao;
import com.atguigu.springboot.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @创建人 ym
 * @创建时间 2021/3/4 0004
 * @描述
 **/
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User queryUserByName(String name){
        return userDao.queryUserByUserName(name);
    }
}
