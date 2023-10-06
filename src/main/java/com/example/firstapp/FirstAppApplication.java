package com.example.firstapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.firstapp")
public class FirstAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(FirstAppApplication.class, args);
    }
}