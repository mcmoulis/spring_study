package com.mcms.study.spring.batch.job.simple;

import javax.batch.api.chunk.ItemProcessor;

import org.springframework.stereotype.Component;

@Component
public class SimpleProcessor implements ItemProcessor {

    @Override
    public Object processItem(Object item) throws Exception {
        return item.toString().toUpperCase();
    }

}
