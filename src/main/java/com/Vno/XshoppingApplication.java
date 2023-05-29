package com.vno;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.vno.mapper")
public class XshoppingApplication {

    public static void main(String[] args) {
        SpringApplication.run(XshoppingApplication.class, args);
    }

}
