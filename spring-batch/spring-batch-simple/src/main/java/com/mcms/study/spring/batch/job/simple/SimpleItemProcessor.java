package com.mcms.study.spring.batch.job.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class SimpleItemProcessor implements ItemProcessor<String, String> {

    private static final Logger log = LoggerFactory.getLogger(SimpleItemProcessor.class);

    public String process(String item) throws Exception {
        log.info(item);
        return item;
    }

}
