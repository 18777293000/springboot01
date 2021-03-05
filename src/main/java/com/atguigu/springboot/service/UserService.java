package com.atguigu.springboot.service;

import com.atguigu.springboot.dao.UserDao;
import com.atguigu.springboot.vo.User;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.springboot.utils.AssertUtil;

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

    public User queryUserById(Integer userId){
        return userDao.queryById(userId);
    }

    public void saveUser(User user){
//        System.out.println(user.getId());
//        System.out.println(user.getName());
//        System.out.println(user.getPwd());
//        User temp = new User(70, "admin", 123456);
//        System.out.println(temp.getId());
//        System.out.println(temp.getName());
//        System.out.println(temp.getPwd());
//        userDao.save(user);
//        AssertUtil.isTrue(StringUtils.isBlank(user.getName()), "用户名不能为空");
//        AssertUtil.isTrue(StringUtils.isBlank(user.getPwd()), "密码不能为空");
        AssertUtil.isTrue(user.getName() == "", "用户名不能为空");
        AssertUtil.isTrue(user.getPwd() == null, "密码不能为空");
        AssertUtil.isTrue(userDao.queryUserByUserName(user.getName()) != null, "用户已经存在");
        AssertUtil.isTrue(userDao.queryById(user.getId()) != null, "用户名不能为空");
        AssertUtil.isTrue(userDao.save(user) < 1, "用户添加失败");
    }

    public void updateUser(User user){
//        AssertUtil.isTrue(StringUtils.isBlank(user.getName()), "用户名不能为空");
//        AssertUtil.isTrue(StringUtils.isBlank(user.getPwd()), "密码不能为空");
        AssertUtil.isTrue(userDao.queryById(user.getId())==null, "用户不存在");

        User temp = userDao.queryUserByUserName(user.getName());
        AssertUtil.isTrue(temp != null && !(temp.getId().equals(user.getId())), "用户已经存在");
        AssertUtil.isTrue(userDao.update(user) < 1, "用户跟新失败");
    }

    public void deleteUser(Integer userId){
        AssertUtil.isTrue(userDao.queryById(userId) == null || userId == null, "用户不存在");
        AssertUtil.isTrue(userDao.delete(userId) < 1, "删除用户失败");
    }
}
