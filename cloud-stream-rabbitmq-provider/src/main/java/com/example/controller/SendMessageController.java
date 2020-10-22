package com.example.controller;

import com.example.service.MessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/22 11:26
 */
@RestController
public class SendMessageController {
    @Resource
    private MessageProvider messageProvider;

    @GetMapping("/send/message")
    public String sendMessage() {
        return messageProvider.send();
    }
}
