package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/23 8:49
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaConsumerSentinelOrder {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaConsumerSentinelOrder.class,args);
    }
}
