package com.mcms.study.spring.boot.web.controller.echo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    @RequestMapping("/echo")
    public String handleEcho(String input) {
        return input;
    }

    @RequestMapping("/echo2")
    public String handleEcho2(String input1, String input2) {
        return input1 + input2;
    }

}
