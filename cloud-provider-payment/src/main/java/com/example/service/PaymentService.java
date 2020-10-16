package com.example.service;

import com.example.entities.Payment;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/14 17:29
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);

    Payment getPaymentByTradeNo(String tradeNo);
}
