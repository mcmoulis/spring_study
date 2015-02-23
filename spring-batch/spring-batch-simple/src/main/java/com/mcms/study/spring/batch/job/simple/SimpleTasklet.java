package com.mcms.study.spring.batch.job.simple;

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
        int stepExecutionsCount = chunkContext.getStepContext().getStepExecution().getJobExecution().getStepExecutions().size();
        LOGGER.info("Total steps executed: {}", stepExecutionsCount - 1);
        if (stepExecutionsCount == 1) {
            throw new Exception("Improper job execution.");
        }
        return RepeatStatus.FINISHED;
    }
}