package com.mcms.study.spring.batch.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.mcms.study.spring.batch.scheduler.model.ExamResult;

public class ExamResultItemProcessor implements ItemProcessor<ExamResult, ExamResult> {

    private static final Logger log = LoggerFactory.getLogger(ExamResultItemProcessor.class);

    public ExamResult process(ExamResult result) throws Exception {
        log.info("Processing result :" + result);

        /*
         * Only return results which are more than 75%
         */
        if (result.getPercentage() < 75) {
            return null;
        }

        return result;
    }

}
