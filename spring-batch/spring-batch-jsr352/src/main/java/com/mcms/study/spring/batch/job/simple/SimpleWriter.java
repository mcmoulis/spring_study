package com.mcms.study.spring.batch.job.simple;

import java.io.Serializable;
import java.util.List;

import javax.batch.api.chunk.ItemWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleWriter implements ItemWriter {
    private static final Logger log = LoggerFactory.getLogger(SimpleWriter.class);

    private int lineNumber;

    @Override
    public Serializable checkpointInfo() throws Exception {
        return lineNumber;
    }

    @Override
    public void open(Serializable checkpoint) throws Exception {
        // Do Nothing
    }

    @Override
    public void close() throws Exception {
        // Do Nothing
    }

    @Override
    public void writeItems(List<Object> items) throws Exception {
        items.stream().forEach(item -> log.info("Item with WRITER: {}", item));
    }

}
