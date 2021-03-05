package com.atguigu.springboot.utils;

import com.atguigu.springboot.exceptions.ParamsException;

/**
 * @创建人 ym
 * @创建时间 2021/3/4 0004
 * @描述
 **/
public class AssertUtil {
    public static void isTrue(Boolean flag, String msg){
        if(flag){
            System.out.println("error");
            throw new ParamsException(msg);
        }
    }
}
