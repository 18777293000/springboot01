package com.atguigu.springboot.web;

import org.springframework.web.bind.annotation.*;
import com.atguigu.springboot.model.student;

import java.util.HashMap;
import java.util.Map;

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

//    @RequestMapping("/student/detail/{id}/{age}")
//    public Object student02(@PathVariable("id") Integer id,
//                             @PathVariable("age") Integer age){
//        Map<String, Object> retMap = new HashMap<>();
//
//        retMap.put("id", id);
//        retMap.put("age", age);
//        return retMap;
//    }
//
//    @RequestMapping("/student/detail/{id}/{status}")
//    public Object student03(@PathVariable("id") Integer id,
//                            @PathVariable("status") Integer status){
//        Map<String, Object> retMap = new HashMap<>();
//
//        retMap.put("id", id);
//        retMap.put("status", status);
//        return retMap;
//    }

    //student02和student03在实际使用过程中虽然不会报错，但是其实语义混淆，会导致参数对应的方法错误
    //下面写RESTFUL风格的参数获取方式，通过注解区分,加上修改路径名的方法

    @GetMapping(value = "/student/detail/{id}/{age}")
    public Object student04(@PathVariable("id") Integer id,
                            @PathVariable("age") Integer age){
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("id", id);
        retMap.put("age", age);

        return retMap;
    }

    @DeleteMapping(value = "/student/detail/{id}/{status}")
    public Object student05(@PathVariable("id") Integer id,
                            @PathVariable("status") Integer status){
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("id", id);
        retMap.put("status", status);
        retMap.put("delete", "delete");

        return retMap;
    }

    @PostMapping(value = "/student/{id}")
    public String addStudent(@PathVariable("id") Integer id){
        return "add student ID :" + id;
    }

    @PutMapping(value = "/student/{id}")
    public String updataStudent(@PathVariable("id") Integer id){
        return "updata student ID :" + id;
    }
}
