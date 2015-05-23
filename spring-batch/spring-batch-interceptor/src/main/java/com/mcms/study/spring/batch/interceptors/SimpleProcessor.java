package com.mcms.study.spring.batch.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class SimpleProcessor implements ItemProcessor<String, String> {

    private static final Logger log = LoggerFactory.getLogger(SimpleProcessor.class);

    public String process(String item) throws Exception {
        log.info("Processing Begin: " + item);
        if (CustomException.getErrorItem().contains(item)) {
            throw new CustomException();
        }
        log.info("Processing Done: " + item);
        return item;
    }

}
