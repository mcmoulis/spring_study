package com.mcms.study.spring.batch.scheduler;

import org.junit.Assert;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleBatchRunner {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    public void performJob() throws Exception {
        ExitStatus status = jobLauncherTestUtils.launchJob(jobLauncherTestUtils.getJob().getJobParametersIncrementer().getNext(new JobParameters()))
                .getExitStatus();
        Assert.assertEquals(ExitStatus.COMPLETED, status);

    }

}
