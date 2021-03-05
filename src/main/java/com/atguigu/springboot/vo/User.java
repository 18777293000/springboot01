package com.atguigu.springboot.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @创建人 ym
 * @创建时间 2021/3/4 0004
 * @描述
 **/
public class User {
    private Integer id;
    private String userName;
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
}
