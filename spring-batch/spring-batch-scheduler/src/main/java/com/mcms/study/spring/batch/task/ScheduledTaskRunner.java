package com.mcms.study.spring.batch.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mcms.study.spring.batch.scheduler.SimpleBatchRunner;

@Component
public class ScheduledTaskRunner {
    @Autowired
    protected SimpleBatchRunner simpleBatchRunner;

    @Scheduled(cron = "0/5 * * * * ?")
    public void triggerJob() throws Exception {
        simpleBatchRunner.performJob();
    }
}