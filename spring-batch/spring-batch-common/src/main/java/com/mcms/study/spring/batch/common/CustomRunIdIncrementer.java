package com.mcms.study.spring.batch.common;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.stereotype.Component;

@Component
public class CustomRunIdIncrementer implements JobParametersIncrementer {

    private static String RUN_ID_KEY = "run.id";
    private static long runId;

    public JobParameters getNext(JobParameters parameters) {
        runId++;
        if (parameters == null) {
            return new JobParametersBuilder().addLong(RUN_ID_KEY, runId).toJobParameters();
        } else {
            return new JobParametersBuilder(parameters).addLong(RUN_ID_KEY, runId).toJobParameters();
        }
    }

}