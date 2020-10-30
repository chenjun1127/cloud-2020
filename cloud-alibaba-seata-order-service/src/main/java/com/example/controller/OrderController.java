package com.example.controller;

import com.example.entities.Order;
import com.example.service.OrderService;
import com.example.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/30 9:31
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult<Object> create(Order order) {
        orderService.create(order);
        return new CommonResult<>(200, "订单创建成功");
    }

}
