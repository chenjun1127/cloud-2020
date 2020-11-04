package com.example.controller;

import com.example.entities.Order;
import com.example.service.OrderService;
import com.example.utils.CommonResult;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: seata分布式全局控制事务
 * @Author: chenjun
 * @Date: 2020/10/30 9:31
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    @GetMapping("/order/create")
    public CommonResult<Object> create(Order order) {
        orderService.create(order);
        return new CommonResult<>(200, "订单创建成功");
    }
}
