package com.mcms.study.spring.batch.interceptors.listeners;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

@Component
public class CustomItemWriterListener implements ItemWriteListener<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomItemWriterListener.class);

    @Override
    public void beforeWrite(List<? extends String> items) {
        LOGGER.info("beforeWrite");
    }

    @Override
    public void afterWrite(List<? extends String> items) {
        LOGGER.info("afterWrite");
    }

    @Override
    public void onWriteError(Exception exception, List<? extends String> items) {
        LOGGER.info("onWriteError");
    }

}
