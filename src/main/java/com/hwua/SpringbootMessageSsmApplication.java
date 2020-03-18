package com.hwua;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackages = "com.hwua.mapper")
@SpringBootApplication
public class SpringbootMessageSsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMessageSsmApplication.class, args);
    }

}
