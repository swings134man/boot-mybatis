package com.boot.batis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatisApplication.class, args);
    }

}
