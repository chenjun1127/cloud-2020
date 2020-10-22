package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/22 11:05
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitmqProvider {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitmqProvider.class, args);
    }
}
