package com.seekerhut;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
@MapperScan("com.seekerhut.mapper")
public class ForumApplication {

    public static void main(String[] args) {
        run(ForumApplication.class, args);
    }
}