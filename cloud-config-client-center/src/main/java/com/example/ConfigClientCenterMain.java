package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: 客户端配置中心
 * @Author: chenjun
 * @Date: 2020/10/21 14:15
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientCenterMain {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientCenterMain.class, args);
    }
}
