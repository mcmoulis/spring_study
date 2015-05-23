package com.mcms.study.spring.batch.job.exception;

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
@SpringApplicationConfiguration(locations = { "classpath:META-INF/spring/rollback-demo-context.xml", "classpath:META-INF/spring/batch-test-context.xml" })
public class RollbackDemoTest {
    @Autowired
    protected JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void testJobforSkipDemoOk() throws Exception {
        ExitStatus status = jobLauncherTestUtils.launchJob(new JobParametersBuilder().toJobParameters()).getExitStatus();
        Assert.assertEquals(ExitStatus.COMPLETED, status);
    }

}