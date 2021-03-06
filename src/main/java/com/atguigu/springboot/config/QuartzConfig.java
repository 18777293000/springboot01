package com.atguigu.springboot.config;

import com.atguigu.springboot.jobs.MyFirstJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @创建人 ym
 * @创建时间 2021/3/6 0006
 * @描述
 **/
//配置项的作用，就是在application启动后，向容器注入这些配置的实体对象，然后有响应的框架去检测获取里面的配置信息

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetail(){
        return JobBuilder.newJob(MyFirstJob.class).storeDurably().build();
    }

    @Bean
    public Trigger trigger1(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(1)
                .repeatForever();
        return TriggerBuilder.newTrigger()
                .withIdentity("trigger1","group1")
                .withSchedule(scheduleBuilder)
                .forJob(jobDetail())
                .build();
    }
}
