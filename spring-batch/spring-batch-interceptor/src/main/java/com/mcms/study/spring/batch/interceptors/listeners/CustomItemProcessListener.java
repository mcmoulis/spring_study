package com.mcms.study.spring.batch.interceptors.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.stereotype.Component;

@Component
public class CustomItemProcessListener implements ItemProcessListener<String, String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomItemProcessListener.class);

    @Override
    public void beforeProcess(String item) {
        LOGGER.info("beforeProcess");
    }

    @Override
    public void afterProcess(String item, String result) {
        LOGGER.info("afterProcess");
    }

    @Override
    public void onProcessError(String item, Exception e) {
        LOGGER.info("onProcessError");
    }

}
