package com.mcms.study.spring.batch.job.simple;

import java.util.Properties;
import java.util.concurrent.TimeoutException;

import javax.batch.runtime.BatchStatus;
import javax.batch.runtime.JobExecution;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.batch.test.JsrTestUtils;

public class Jsr352SampleTest {

    static {
        System.setProperty("ENVIRONMENT", "h2");
    }

    @Test
    public void testJobJsr352Simple() throws TimeoutException {
        JobExecution jobExecution = JsrTestUtils.runJob("jobJsr352Simple", new Properties(), 60 * 60 * 1000);
        Assert.assertEquals(BatchStatus.COMPLETED, jobExecution.getBatchStatus());
    }

    @Test
    public void testJobJsr352Partition() throws TimeoutException {
        JobExecution jobExecution = JsrTestUtils.runJob("jobJsr352Partition", new Properties(), 60 * 60 * 1000);
        Assert.assertEquals(BatchStatus.COMPLETED, jobExecution.getBatchStatus());
    }
}