package com.main.funtrip.test.controller;

import com.main.funtrip.common.config.StartupApplicationListenerConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/test")
public class testController {
    private static final Logger LOG = Logger.getLogger(String.valueOf(testController.class));
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/test")
    public List<String> test(){
        LOG.info("test11111");
        return Arrays.asList("서버", "연결");
    }
}
