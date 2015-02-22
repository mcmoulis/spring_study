package com.mcms.study.spring.batch.job.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;

public class SimpleReader implements ItemReader<String> {
    private static final Logger log = LoggerFactory.getLogger(SimpleReader.class);

    public static final String[] SOURCE_ARRAY = { "1", "2", "3", "4", "5" };

    private int index = 0;

    public String read() throws Exception {
        String item = null;
        if (index < SOURCE_ARRAY.length) {
            item = SOURCE_ARRAY[index++];
            log.info(item);
            return item;
        } else {
            return null;
        }

    }

}
