package com.atguigu.boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @创建人 ym
 * @创建时间 2021/3/2 0002
 * @描述
 **/
@RestController
public class WorldController {

    @RequestMapping("/w")
    public String world(){
        return "world springboot";
    }
}
