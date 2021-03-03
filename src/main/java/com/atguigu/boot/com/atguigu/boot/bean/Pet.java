package com.atguigu.boot.com.atguigu.boot.bean;

/**
 * @创建人 ym
 * @创建时间 2021/3/3 0003
 * @描述
 **/
public class Pet {
    private String name;

    public Pet(){};

    public Pet(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
