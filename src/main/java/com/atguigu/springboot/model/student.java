package com.atguigu.springboot.model;

/**
 * @创建人 ym
 * @创建时间 2021/3/3 0003
 * @描述
 **/
public class student {
    private Integer id;
    private Integer age;

    public void Student(){}

    public void Student(Integer id, Integer age){
        this.id = id;
        this.age = age;
    }

    public Integer getId(){
        return id;
    }

    public Integer getAge(){
        return age;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    @Override
    public String toString(){
        return "student{" + "id=" + id + "," + "age=" + age + "}" ;
    }
}
