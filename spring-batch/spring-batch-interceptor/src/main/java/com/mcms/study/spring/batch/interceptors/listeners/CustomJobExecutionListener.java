package com.mcms.study.spring.batch.interceptors.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class CustomJobExecutionListener implements JobExecutionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomJobExecutionListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        LOGGER.info("beforeJob");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        LOGGER.info("afterJob");
    }

}