package com.example.mapper;

import com.example.entities.Payment;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/14 17:21
 */
public interface PaymentMapper {
    int create(Payment payment);

    Payment getPaymentById(Long id);

    Payment getPaymentByTradeNo(String tradeNo);
}
