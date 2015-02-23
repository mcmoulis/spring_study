package com.mcms.study.spring.batch.job.simple;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class SimpleTasklet implements Tasklet {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleTasklet.class);

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        List<Throwable> jobFailureExceptions = chunkContext.getStepContext().getStepExecution().getJobExecution().getFailureExceptions();
        for (Throwable throwable : jobFailureExceptions) {
            LOGGER.info("Occurred exception: {}", throwable);
        }
        if (!jobFailureExceptions.isEmpty()) {
            throw new Exception("Improper job execution.");
        }
        return RepeatStatus.FINISHED;
    }
}