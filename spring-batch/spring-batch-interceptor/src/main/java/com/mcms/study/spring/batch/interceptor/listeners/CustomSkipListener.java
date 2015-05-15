package com.mcms.study.spring.batch.interceptor.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.SkipListener;

public class CustomSkipListener<T, S> implements SkipListener<T, S> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomSkipListener.class);
    
    @Override
    public void onSkipInRead(Throwable t) {
        LOGGER.info("CustomSkipListener - onSkipInRead");

    }

    @Override
    public void onSkipInWrite(S item, Throwable t) {
        LOGGER.info("CustomSkipListener - onSkipInWrite");        
    }

    @Override
    public void onSkipInProcess(T item, Throwable t) {
        LOGGER.info("CustomSkipListener - onSkipInProcess");        
    }

}