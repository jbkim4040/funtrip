package com.main.funtrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class FuntripApplication {
    /** push TEST    **/
    public static void main(String[] args) {
        SpringApplication.run(FuntripApplication.class, args);
    }

}
