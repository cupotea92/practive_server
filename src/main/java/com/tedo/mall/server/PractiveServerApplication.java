package com.tedo.mall.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tedo.mall.server.mapper")
public class PractiveServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PractiveServerApplication.class, args);
    }

}
