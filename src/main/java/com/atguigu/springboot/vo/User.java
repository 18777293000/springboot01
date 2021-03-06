package com.atguigu.springboot.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @创建人 ym
 * @创建时间 2021/3/4 0004
 * @描述
 **/

@ApiModel(description = "用户实体对象")
public class User implements Serializable {

    @ApiModelProperty(value = "用户ID")
    private Integer id;

    @ApiModelProperty(value = "用户民")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    private Integer userPwd;

    public User(){}

    public User(Integer id, String userName, Integer userPwd){
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return userName;
    }

    public Integer getPwd(){
        return userPwd;
    }

    @JsonProperty(value = "id")
    public void setId(Integer id){
        this.id = id;
    }
    @JsonProperty(value = "userName")
    public void setName(String name){
        this.userName = name;
    }
    @JsonProperty(value = "userPwd")
    public void setPwd(Integer pwd){
        this.userPwd = pwd;
    }

    @Override
    public String toString(){
        return "User{" +
                "id=" + id +
                ", userName=" + userName + '\'' +
                ", userPwd=" + userPwd + '\'' +
                "}";
    }
}
