package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/26 17:18
 */
@RestController
@RequestMapping("sentinel")
public class FlowLimitController {
    @GetMapping("/test-a")
    public String testA() {
        return "----testA";
    }

    @GetMapping("/test-b")
    public String testB() {
        return "----testB";
    }
}
