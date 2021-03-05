package com.atguigu.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @创建人 ym
 * @创建时间 2021/3/5 0005
 * @描述
 **/
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.atguigu.springboot.controller"))
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("用户管理接口文档参考")
                .version("1.0")
                .build();
    }
}
