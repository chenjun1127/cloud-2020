package com.example.service.impl;

import com.example.service.MessageProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/22 11:18
 */
@EnableBinding(Source.class) // 定义消息的推送管道
public class MessageProviderImpl implements MessageProvider {
    Logger logger = LoggerFactory.getLogger(MessageProviderImpl.class);
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        logger.info("serial: " + serial);
        return null;
    }
}
