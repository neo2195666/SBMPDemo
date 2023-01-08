package com.example.sbmpdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.sbmpdemo.mapper")
public class SbmpDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbmpDemoApplication.class, args);
    }

}
