package com.atguigu.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.atguigu.springboot.model.student;

/**
 * @创建人 ym
 * @创建时间 2021/3/3 0003
 * @描述
 **/
@RestController
public class StudentController {

    @RequestMapping("/student")
    public student student01(Integer id, Integer age){
        student student01 = new student();
        student01.setId(id);
        student01.setAge(age);
        return student01;
    }
}
