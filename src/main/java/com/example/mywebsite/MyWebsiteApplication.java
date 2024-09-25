package com.example.mywebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(scanBasePackages = "com.example.kunddatabas")
public class MyWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyWebsiteApplication.class, args);
    }

}
