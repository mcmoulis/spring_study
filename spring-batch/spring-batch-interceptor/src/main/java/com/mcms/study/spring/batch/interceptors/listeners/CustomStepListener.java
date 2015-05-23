package com.mcms.study.spring.batch.interceptors.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class CustomStepListener implements StepExecutionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomStepListener.class);

    @Override
    public void beforeStep(StepExecution stepExecution) {
        LOGGER.info("beforeStep");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        LOGGER.info("afterStep");
        return ExitStatus.COMPLETED;
    }

}