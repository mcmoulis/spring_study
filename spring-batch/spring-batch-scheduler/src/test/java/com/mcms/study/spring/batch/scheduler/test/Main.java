package com.mcms.study.spring.batch.scheduler.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    @SuppressWarnings({ "unused", "resource" })
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/scheduler-context.xml");
    }
}