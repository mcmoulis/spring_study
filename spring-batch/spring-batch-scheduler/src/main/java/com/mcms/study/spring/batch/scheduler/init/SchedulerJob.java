package com.mcms.study.spring.batch.scheduler.init;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.mcms.study.spring.batch.scheduler.SpringBatchJob;

@DisallowConcurrentExecution
public class SchedulerJob extends QuartzJobBean {

    private static final Logger log = LoggerFactory.getLogger(SchedulerJob.class);
    private String batchJob;

    public void setBatchJob(String batchJob) {
        this.batchJob = batchJob;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) {

        ApplicationContext applicationContext = ApplicationContextUtil.getApplicationContext();
        SpringBatchJob job = applicationContext.getBean(batchJob, SpringBatchJob.class);
        log.info("Quartz job started: " + job);

        try {
            job.performJob();

        } catch (Exception exception) {
            log.info("Job " + batchJob + " could not be executed : " + exception.getMessage());
        }
        log.info("Quartz job end");
    }
}