package com.mcms.study.spring.batch.scheduler.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TaskSchedulerDemoMain {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("META-INF/spring/task-scheduler-context.xml");
    }
}