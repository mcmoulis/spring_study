package com.mcms.study.spring.batch.interceptors.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.stereotype.Component;

@Component
public class CustomItemReaderListener implements ItemReadListener<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomItemReaderListener.class);

    @Override
    public void beforeRead() {
        LOGGER.info("beforeRead");
    }

    @Override
    public void afterRead(String item) {
        LOGGER.info("afterRead: " + item);
    }

    @Override
    public void onReadError(Exception ex) {
        LOGGER.info("onReadError");
    }

}
