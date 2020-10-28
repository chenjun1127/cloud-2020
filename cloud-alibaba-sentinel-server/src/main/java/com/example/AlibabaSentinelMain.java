package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/26 17:16
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaSentinelMain {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaSentinelMain.class, args);
    }
}
