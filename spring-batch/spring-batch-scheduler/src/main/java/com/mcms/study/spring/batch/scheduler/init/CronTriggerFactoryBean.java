package com.mcms.study.spring.batch.scheduler.init;

import org.quartz.CronScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.FactoryBean;

public class CronTriggerFactoryBean implements FactoryBean<Trigger> {

    private final String jobName;

    private final String cronExpression;

    public CronTriggerFactoryBean(String jobName, String cronExpression) {
        this.jobName = jobName;
        this.cronExpression = cronExpression;
    }

    public Trigger getObject() throws Exception {
        return TriggerBuilder.newTrigger().forJob(jobName, "DEFAULT").withIdentity(jobName + "Trigger", "DEFAULT")
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).build();
    }

    public Class<?> getObjectType() {
        return Trigger.class;
    }

    public boolean isSingleton() {
        return false;
    }

}
