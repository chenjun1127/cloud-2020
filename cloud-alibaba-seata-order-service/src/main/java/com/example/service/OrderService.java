package com.example.service;

import com.example.entities.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/29 18:17
 */
public interface OrderService {
    void create(Order order);
}
