package com.mcms.study.spring.batch.interceptors;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class SimpleWriter implements ItemWriter<Object> {
    private static final Logger log = LoggerFactory.getLogger(SimpleWriter.class);

    public void write(List<? extends Object> data) throws Exception {
        log.info("Write Begin: " + data);
        if (data.contains(CustomException.getWriteErrorItem())) {
            throw new CustomException();
        }
        log.info("Write Done: " + data);
    }

}