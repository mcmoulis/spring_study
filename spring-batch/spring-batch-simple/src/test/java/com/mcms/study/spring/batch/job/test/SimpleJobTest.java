package com.mcms.study.spring.batch.job.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/job-simple-context.xml", "classpath:META-INF/spring/batch-test-context.xml" })
public class SimpleJobTest {
    @Autowired
    protected JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void testJob() throws Exception {
        ExitStatus status = jobLauncherTestUtils.launchJob(new JobParametersBuilder().addDate("when", new Date()).toJobParameters()).getExitStatus();
        Assert.assertEquals(ExitStatus.COMPLETED, status);
    }

    @Test
    public void testStep() throws Exception {
        ExitStatus status = jobLauncherTestUtils.launchStep("stepEnd").getExitStatus();
        Assert.assertEquals(ExitStatus.COMPLETED, status);
    }

}