package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Description: 配置中心服务端
 * @Author: chenjun
 * @Date: 2020/10/21 16:48
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerCenterMain {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerCenterMain.class, args);
    }
}