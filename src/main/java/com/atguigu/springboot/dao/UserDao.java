package com.atguigu.springboot.dao;

import com.atguigu.springboot.vo.User;
import org.springframework.stereotype.Repository;

/**
 * @创建人 ym
 * @创建时间 2021/3/4 0004
 * @描述
 **/
@Repository
public interface UserDao {
     public User queryUserByUserName(String name);
}
