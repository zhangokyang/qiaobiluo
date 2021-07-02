package com.kuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class Springboot04DataApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot04DataApplication.class, args);
    }

}
