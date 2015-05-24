package com.mcms.study.spring.batch.scheduler.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuartzSchedulerDemoMain {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("META-INF/spring/quartz-scheduler-context.xml");
    }
}