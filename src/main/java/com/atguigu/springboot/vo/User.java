package com.atguigu.springboot.vo;

/**
 * @创建人 ym
 * @创建时间 2021/3/4 0004
 * @描述
 **/
public class User {
    private Integer id;
    private String user_name;
    private Integer user_pwd;

    public User(){}

    public User(Integer id, String user_name, Integer user_pwd){
        this.id = id;
        this.user_name = user_name;
        this.user_pwd = user_pwd;
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return user_name;
    }

    public Integer getPwd(){
        return user_pwd;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setName(String name){
        this.user_name = name;
    }

    public void setPwd(Integer pwd){
        this.user_pwd = pwd;
    }
}
