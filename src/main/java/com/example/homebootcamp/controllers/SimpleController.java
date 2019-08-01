package com.example.homebootcamp.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@Component
public class SimpleController {
    private final Logger logger = LogManager.getLogger(getClass().getName());

    @RequestMapping("/")
    public String hello(HttpServletRequest request, @RequestHeader Map headers){
        return "Hello";
    }
}
