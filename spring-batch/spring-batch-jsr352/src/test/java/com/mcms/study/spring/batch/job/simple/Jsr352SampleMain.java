package com.mcms.study.spring.batch.job.simple;

import java.util.Properties;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;

public class Jsr352SampleMain {

    public static void main(String[] args) {
        System.setProperty("ENVIRONMENT", "h2");
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        jobOperator.start("jobJsr352Simple", new Properties());
    }
}