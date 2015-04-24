package com.mcms.study.spring.batch.job.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(locations = { "classpath:META-INF/spring/job-composite-policy-context.xml", "classpath:META-INF/spring/batch-test-context.xml" })
public class CompositePolicyTest {
    @Autowired
    protected JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void testJob() throws Exception {
        ExitStatus status = jobLauncherTestUtils.launchJob(new JobParametersBuilder().addDate("when", new Date()).toJobParameters()).getExitStatus();
        Assert.assertEquals(ExitStatus.COMPLETED, status);
    }

}