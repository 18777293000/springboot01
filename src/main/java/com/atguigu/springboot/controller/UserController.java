package com.atguigu.springboot.controller;

import com.atguigu.springboot.exceptions.ParamsException;
import com.atguigu.springboot.model.ResultInfo;
import com.atguigu.springboot.service.UserService;
import com.atguigu.springboot.vo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("user/uname/{userName}")
    public User queryUserByUserName( @PathVariable("userName") String userName ){
        return userService.queryUserByName(userName);
    }

    @GetMapping("user/uId/{userId}")
    public User queryUserById(@PathVariable Integer userId){
        return userService.queryUserById(userId);
    }

    public ResultInfo saveUser(@RequestBody User user){
        //saveuser里面没有返回值，所以不用像上面两个一样要return，但是要做返回错误捕捉
        //自定义错误类，来自定义返回的错误对象
        ResultInfo resultInfo = new ResultInfo();
        try {
            userService.saveUser(user);
        }catch(ParamsException e){
            resultInfo.setCode(e.getCode());
            resultInfo.setMsg(e.getMsg());
            e.printStackTrace();
        }catch(Exception e){
            resultInfo.setCode(300);
            resultInfo.setMsg("用户添加失败！");
            e.printStackTrace();
        }
        return resultInfo;
    }


}
