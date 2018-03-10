package com.mcms.study.spring.boot.web;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mcms.study.spring.boot.web.controller.DefaultController;
import com.mcms.study.spring.boot.web.controller.echo.EchoController;

@RunWith(SpringRunner.class)
@WebMvcTest
public class WebApplicationTest {

    @Inject
    private DefaultController defaultController;

    @Inject
    private EchoController echoController;

    @Test
    public void testInit() {
        assertThat(defaultController).isNotNull();
        assertThat(echoController).isNotNull();
    }
}