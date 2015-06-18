package com.mcms.study.spring.batch.scalability.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.listener.ItemListenerSupport;

import com.mcms.study.spring.batch.scalability.reader.User;

public class UserChunkListener extends ItemListenerSupport<User, User> {

    private static final Logger log = LoggerFactory.getLogger(UserChunkListener.class);

    @Override
    public void onReadError(Exception ex) {
        log.error(ex.getMessage(), ex);
    }
}
