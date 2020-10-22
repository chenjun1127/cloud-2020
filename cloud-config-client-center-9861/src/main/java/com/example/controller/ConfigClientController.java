package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/21 14:17
 */
@RestController
@RefreshScope // github上的配置修改了，客户端要实现实时刷新，还需要手动运行命令curl -X POST "http://localhost:9860/actuator/refresh"，避免重复服务
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
