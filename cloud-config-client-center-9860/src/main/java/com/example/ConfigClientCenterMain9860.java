package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: 客户端配置中心
 * @Author: chenjun
 * @Date: 2020/10/21 14:15
 */
@SpringBootApplication
@EnableEurekaClient
@RefreshScope // 客户端配置中心手动刷新，还需要手动运行命令 curl -X POST "http://localhost:9860/actuator/refresh"
public class ConfigClientCenterMain9860 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientCenterMain9860.class, args);
    }
}
