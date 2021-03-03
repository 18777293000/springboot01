package com.atguigu.boot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @创建人 ym
 * @创建时间 2021/3/3 0003
 * @描述
 **/

@Component
@ConfigurationProperties(prefix="mycar")
public class Car {
    private String brand;
    private Integer price;

//    public Car(){}
//
//    public Car(String brand, Integer price){
//        this.brand = brand;
//        this.price = price;
//    }

    public String getBrand(){
        return brand;
    }

    public Integer getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return "car{brand=" + brand + "/" + "price=" + price + "}";
    }
}
