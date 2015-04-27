package com.mcms.study.spring.batch.job.simple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.ItemReader;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleFileReader implements ItemReader {
    private static final Logger log = LoggerFactory.getLogger(SimpleFileReader.class);

    private BufferedReader lineReader;
    private int lineNumber;

    @Inject
    @BatchProperty
    private String fileName;

    @Override
    public Serializable checkpointInfo() throws Exception {
        return lineNumber;
    }

    @Override
    public void open(Serializable checkpoint) throws Exception {
        lineReader = new BufferedReader(new FileReader(fileName));

        if (checkpoint != null) {
            lineNumber = (Integer) checkpoint;
            for (int i = 0; i < lineNumber; i++) {
                lineReader.readLine();
            }
        }
    }

    @Override
    public void close() throws Exception {
        lineReader.close();
    }

    @Override
    public Object readItem() throws Exception {
        lineNumber++;
        String line = lineReader.readLine();
        log.info("Item from READER: {}", line);
        return line;
    }

}
