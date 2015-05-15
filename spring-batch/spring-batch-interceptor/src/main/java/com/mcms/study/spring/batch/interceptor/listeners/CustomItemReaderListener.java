package com.mcms.study.spring.batch.interceptor.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemReadListener;

import com.mcms.study.spring.batch.interceptor.Domain;

public class CustomItemReaderListener implements ItemReadListener<Domain> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomItemReaderListener.class);
    
    @Override
    public void beforeRead() {
        LOGGER.info("ItemReadListener - beforeRead");
    }

    @Override
    public void afterRead(Domain item) {
        LOGGER.info("ItemReadListener - afterRead");
    }

    @Override
    public void onReadError(Exception ex) {
        LOGGER.info("ItemReadListener - onReadError");
    }

}
