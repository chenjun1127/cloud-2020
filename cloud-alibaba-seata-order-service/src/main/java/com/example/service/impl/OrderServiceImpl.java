package com.example.service.impl;

import com.example.entities.Order;
import com.example.mapper.OrderMapper;
import com.example.service.AccountService;
import com.example.service.OrderService;
import com.example.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/29 18:17
 */
@Service
public class OrderServiceImpl implements OrderService {
    public static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @Override
    public void create(Order order) {
        logger.info("--->开始新建订单");
        orderMapper.create(order);
        logger.info("--->订单微服务开始调用库存，做扣减");
        storageService.decrease(order.getProductId(), order.getCount());
        logger.info("--->订单微服务开始调用账户，做扣减");
        accountService.decrease(order.getUserId(), order.getMoney());
        logger.info("--->修改订单状态");
        // 修改订单状态 ，1表示已完成
        orderMapper.update(order.getUserId(), 0);
        logger.info("--->下订单结束");
    }
}
