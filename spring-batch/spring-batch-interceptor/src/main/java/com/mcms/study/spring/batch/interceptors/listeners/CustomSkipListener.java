package com.mcms.study.spring.batch.interceptors.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.SkipListener;
import org.springframework.stereotype.Component;

@Component
public class CustomSkipListener<T, S> implements SkipListener<T, S> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomSkipListener.class);

    @Override
    public void onSkipInRead(Throwable t) {
        LOGGER.info("onSkipInRead");
    }

    @Override
    public void onSkipInWrite(S item, Throwable t) {
        LOGGER.info("onSkipInWrite");
    }

    @Override
    public void onSkipInProcess(T item, Throwable t) {
        LOGGER.info("onSkipInProcess");
    }

}