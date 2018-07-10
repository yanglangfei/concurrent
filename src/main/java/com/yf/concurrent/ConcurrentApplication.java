package com.yf.concurrent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yf.concurrent.mapper")
public class ConcurrentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConcurrentApplication.class, args);
    }
}
