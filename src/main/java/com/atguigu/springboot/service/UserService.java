package com.atguigu.springboot.service;

import com.atguigu.springboot.dao.UserDao;
import com.atguigu.springboot.vo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import com.atguigu.springboot.utils.AssertUtil;
import com.atguigu.springboot.query.UserQuery;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import springfox.documentation.annotations.Cacheable;

import java.util.List;

/**
 * @创建人 ym
 * @创建时间 2021/3/4 0004
 * @描述
 **/
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    //这里的value要和ehcache.xml文件里面的name保持一致
    @Cacheable(value="users")
    public User queryUserByName(String name){
        System.out.println("进入查询语句");
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

    @CacheEvict(value="users", key="#user.id")
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(User user){
//        AssertUtil.isTrue(StringUtils.isBlank(user.getName()), "用户名不能为空");
//        AssertUtil.isTrue(StringUtils.isBlank(user.getPwd()), "密码不能为空");
        AssertUtil.isTrue(userDao.queryById(user.getId())==null, "用户不存在");

        User temp = userDao.queryUserByUserName(user.getName());
//        AssertUtil.isTrue(temp != null && !(temp.getId().equals(user.getId())), "用户已经存在");
        AssertUtil.isTrue(userDao.update(user) < 1, "用户跟新失败");
    }

    //添加这两个属性，每次访问接口，根据user删除缓存中的信息
    @Transactional(propagation = Propagation.REQUIRED)
    @CacheEvict(value = "users", allEntries=true)
    public void deleteUser(Integer userId){
        AssertUtil.isTrue(userDao.queryById(userId) == null || userId == null, "用户不存在");
        AssertUtil.isTrue(userDao.delete(userId) < 1, "删除用户失败");
    }

    //通过这样，把参数拼接成字符串作为缓存的key值，当其中一个参数变化，就重新查询,不知道是不是版本问题，这个版本下的cachable没有key值
//    @Cacheable(value="users", key="#userQuery.userName+'-'#userQuery.pageNum+'-'#userQuery.PageSize")
    public PageInfo<User> queryUserByParams(UserQuery userQuery){
        PageHelper.startPage(userQuery.getPageNum(), userQuery.getPageSize());
        List<User> users = userDao.selectByParame(userQuery);
        return new PageInfo<User>(users);
    }
}
