package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/30 9:48
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@MapperScan("com.example.mapper")
@EnableFeignClients
public class AlibabaSeataAccountMain {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaSeataAccountMain.class,args);
    }
}


