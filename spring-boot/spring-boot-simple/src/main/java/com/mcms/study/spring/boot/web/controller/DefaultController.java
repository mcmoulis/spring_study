package com.mcms.study.spring.boot.web.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping("/error")
    public String handleError() {
        return "Error occurred.";
    }

    @RequestMapping("/")
    public String handleLandingPage() {
        return "Welcome";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}