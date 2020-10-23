package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/22 18:03
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaProvidePayment9902 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaProvidePayment9902.class, args);
    }
}
