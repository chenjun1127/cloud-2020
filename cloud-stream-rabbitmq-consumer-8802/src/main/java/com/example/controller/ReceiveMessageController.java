package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

/**
 * @Description: 消费者
 * @Author: chenjun
 * @Date: 2020/10/22 14:21
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageController {
    private final static Logger logger = LoggerFactory.getLogger(ReceiveMessageController.class);
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void receiveMessage(Message<String> msg) {
        logger.info("消费者，端口：" + serverPort + "，接受消息：msg=" + msg.getPayload());
    }
}
