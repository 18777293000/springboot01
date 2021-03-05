package com.atguigu.springboot.controller;

import com.atguigu.springboot.exceptions.ParamsException;
import com.atguigu.springboot.model.ResultInfo;
import com.atguigu.springboot.query.UserQuery;
import com.atguigu.springboot.service.UserService;
import com.atguigu.springboot.vo.User;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @创建人 ym
 * @创建时间 2021/3/4 0004
 * @描述
 **/
@RestController
@Api(tags = "用户模块管理")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("user/uname/{userName}")
    @ApiOperation(value="用户模块-根据用户名查询用户记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value="用户名", required = true, paramType = "String")
    })
    @ApiResponses({
            @ApiResponse(code=300, message="参数错误"),
            @ApiResponse(code=400, message="路由错误,都是随便写的")
    })
    public User queryUserByUserName( @PathVariable("userName") String userName ){
        return userService.queryUserByName(userName);
    }

    @GetMapping("user/uId/{userId}")
    @ApiOperation(value="用户模块-根据用户ID查询用户记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value="用户ID", required = true, paramType = "Path")
    })
    public User queryUserById(@PathVariable Integer userId){
        return userService.queryUserById(userId);
    }

    @PutMapping(value = "user", consumes = "application/json")
    @ResponseBody
    @ApiOperation(value="用户模块-新增用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户", required = true, paramType = "User")
    })
    public ResultInfo saveUser(@RequestBody User user){
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getPwd());
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

    @PostMapping("user")
    @ApiOperation(value="用户模块-更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户", required = true, paramType = "User")
    })
    public ResultInfo updateUser(@RequestBody User user){
        //saveuser里面没有返回值，所以不用像上面两个一样要return，但是要做返回错误捕捉
        //自定义错误类，来自定义返回的错误对象
        ResultInfo resultInfo = new ResultInfo();
        try {
            userService.updateUser(user);
        }catch(ParamsException e){
            resultInfo.setCode(e.getCode());
            resultInfo.setMsg(e.getMsg());
            e.printStackTrace();
        }catch(Exception e){
            resultInfo.setCode(300);
            resultInfo.setMsg("用户跟新失败！");
            e.printStackTrace();
        }
        return resultInfo;
    }

    @DeleteMapping("user/del/{userId}")
    @ApiOperation(value="用户模块-删除用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, paramType = "Integer")
    })
    public ResultInfo delete(@PathVariable Integer userId){
        //saveuser里面没有返回值，所以不用像上面两个一样要return，但是要做返回错误捕捉
        //自定义错误类，来自定义返回的错误对象
        ResultInfo resultInfo = new ResultInfo();
        try {
            userService.deleteUser(userId);
        }catch(ParamsException e){
            resultInfo.setCode(e.getCode());
            resultInfo.setMsg(e.getMsg());
            e.printStackTrace();
        }catch(Exception e){
            resultInfo.setCode(300);
            resultInfo.setMsg("用户删除失败！");
            e.printStackTrace();
        }
        return resultInfo;
    }

    @GetMapping("user/list")
    @ApiOperation(value="用户模块-获取用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userQuery", value = "列表参数", required = true, paramType = "UserQuery")
    })
    public PageInfo<User> queryUserByParams(UserQuery userQuery){
        return userService.queryUserByParams(userQuery);
    }


}
