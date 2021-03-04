package com.atguigu.springboot.dao;

import com.atguigu.springboot.vo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @创建人 ym
 * @创建时间 2021/3/4 0004
 * @描述
 **/
@Repository
public interface UserDao {
     public User queryUserByUserName(String name);

     public User queryById(Integer id);

     public int save(User user);

     public int update(User user);

//     public List<User> selectByParame(UserQuery userQuery);

     public int delete(Integer id);
}
