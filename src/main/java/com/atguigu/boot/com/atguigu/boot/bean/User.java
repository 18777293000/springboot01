package com.atguigu.boot.com.atguigu.boot.bean;

/**
 * @创建人 ym
 * @创建时间 2021/3/3 0003
 * @描述
 **/
public class User {
    private String name;
    private Integer age;

    public User(){};

    public User(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public Integer getAge(){
        return age;
    }
}
