package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/21 11:39
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerCenterMain {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerCenterMain.class, args);
    }
}
