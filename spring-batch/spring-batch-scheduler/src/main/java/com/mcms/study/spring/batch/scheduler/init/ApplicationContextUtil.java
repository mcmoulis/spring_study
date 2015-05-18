package com.mcms.study.spring.batch.scheduler.init;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContextUtil instance;

    private ApplicationContext applicationContext;

    private static synchronized ApplicationContextUtil getInstance() {

        if (instance == null) {
            instance = new ApplicationContextUtil();
        }

        return instance;
    }

    public static ApplicationContext getApplicationContext() {
        return getInstance().applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (getInstance().applicationContext == null) {
            getInstance().applicationContext = applicationContext;
        }

    }

}
