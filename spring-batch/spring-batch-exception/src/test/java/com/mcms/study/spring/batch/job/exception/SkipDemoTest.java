package com.mcms.study.spring.batch.job.exception;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(locations = { "classpath:META-INF/spring/skip-demo-context.xml", "classpath:META-INF/spring/batch-test-context.xml" })
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class SkipDemoTest {
    @Autowired
    protected JobLauncherTestUtils jobLauncherTestUtils;

    @Before
    public void setup() {
        CustomException.initErrorItem();
    }

    @Test
    public void testJobforSkipDemoOk() throws Exception {
        ExitStatus status = jobLauncherTestUtils.launchJob(new JobParametersBuilder().toJobParameters()).getExitStatus();
        Assert.assertEquals(ExitStatus.COMPLETED, status);
    }

    @Test
    public void testJobforSkipDemoFail() throws Exception {
        CustomException.setErrorItem("23");
        ExitStatus status = jobLauncherTestUtils.launchJob(new JobParametersBuilder().toJobParameters()).getExitStatus();
        Assert.assertEquals(ExitStatus.FAILED, status);
    }

}