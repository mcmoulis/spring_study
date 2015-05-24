package com.mcms.study.spring.batch.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.mcms.study.spring.batch.scheduler.SimpleBatchRunner;

public class SimpleJob extends QuartzJobBean {

    protected SimpleBatchRunner simpleBatchRunner;

    public void setSimpleBatchRunner(SimpleBatchRunner simpleBatchRunner) {
        this.simpleBatchRunner = simpleBatchRunner;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            simpleBatchRunner.performJob();
        } catch (Exception e) {
            throw new JobExecutionException(e);
        }
    }
}