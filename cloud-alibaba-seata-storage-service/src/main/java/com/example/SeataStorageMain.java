package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/30 9:55
 */
@SpringBootApplication
@EnableFeignClients
@MapperScan("com.example.mapper")
@EnableDiscoveryClient
public class SeataStorageMain {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageMain.class, args);
    }
}


