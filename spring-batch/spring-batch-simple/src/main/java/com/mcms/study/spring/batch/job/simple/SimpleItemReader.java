package com.mcms.study.spring.batch.job.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;

public class SimpleItemReader implements ItemReader<String> {
    private static final Logger log = LoggerFactory.getLogger(SimpleItemReader.class);

    private String[] input = { "1", "2", "3", "4", "5" };

    private int index = 0;

    public String read() throws Exception {
        String item = null;
        if (index < input.length) {
            item = input[index++];
            log.info(item);
            return item;
        } else {
            return null;
        }

    }

}
