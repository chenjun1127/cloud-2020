package com.example.service;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/19 15:57
 */
@Component
public class PaymentHystrixFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfoOk(int id) {
        return "---paymentHystrixFallbackService--paymentInfoOk";
    }

    @Override
    public String paymentInfoTimeOut(int id) {
        return "---paymentHystrixFallbackService--paymentInfoTimeOut";
    }
}
