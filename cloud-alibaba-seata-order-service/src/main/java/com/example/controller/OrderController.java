package com.example.controller;

import com.example.entities.Order;
import com.example.service.OrderService;
import com.example.utils.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/30 9:31
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult<Object> create(Order order) {
        orderService.create(order);
        return new CommonResult<>(200, "订单创建成功");
    }

}
