package com.mcms.study.spring.batch.interceptor.listeners;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemWriteListener;

import com.mcms.study.spring.batch.interceptor.Domain;

public class CustomItemWriterListener implements ItemWriteListener<Domain> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomItemWriterListener.class);
    
    @Override
    public void beforeWrite(List<? extends Domain> items) {
        LOGGER.info("ItemWriteListener - beforeWrite");
    }

    @Override
    public void afterWrite(List<? extends Domain> items) {
        LOGGER.info("ItemWriteListener - afterWrite");
    }

    @Override
    public void onWriteError(Exception exception, List<? extends Domain> items) {
        LOGGER.info("ItemWriteListener - onWriteError");
    }

}
