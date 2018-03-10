package com.mcms.study.spring.boot.web.controller.echo;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = EchoController.class)
public class EchoControllerTest {

    @Inject
    private MockMvc mockMvc;

    @Test
    public void testHandleEcho() throws Exception {
        String input = "Echo Me";
        mockMvc.perform(get("/echo?input=" + input))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(input)));
    }

    @Test
    public void testHandleEcho2() throws Exception {
        String input = "Echo Me";
        mockMvc.perform(get("/echo2?input1={input1}&input2={input2}", input, input))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(input + input)));
    }

}