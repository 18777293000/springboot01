package com.atguigu.springboot.jobs;

import org.junit.platform.commons.logging.LoggerFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.TriggerKey;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * @创建人 ym
 * @创建时间 2021/3/6 0006
 * @描述
 **/
public class MyFirstJob implements Job {
//    private Logger log = LoggerFactory.getLogger(MyFirstJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        TriggerKey triggerKey = context.getTrigger().getKey();
        System.out.println(triggerKey.getName());
        System.out.println(simpleDateFormat.format(new Date()));
    }
}
