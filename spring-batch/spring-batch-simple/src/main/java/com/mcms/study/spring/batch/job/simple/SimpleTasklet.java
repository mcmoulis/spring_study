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
        LOGGER.info("Size of array used by reader: {}", SimpleReader.SOURCE_ARRAY.length);
        return RepeatStatus.FINISHED;
    }
}