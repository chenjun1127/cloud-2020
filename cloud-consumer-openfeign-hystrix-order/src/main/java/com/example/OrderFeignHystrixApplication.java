package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/19 13:39
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderFeignHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrixApplication.class,args);
    }
}
