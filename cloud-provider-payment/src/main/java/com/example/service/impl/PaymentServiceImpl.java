package com.example.service.impl;

import com.example.entities.Payment;
import com.example.mapper.PaymentMapper;
import com.example.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/14 17:31
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentMapper paymentMapper;
    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }

    @Override
    public Payment getPaymentByTradeNo(String tradeNo) {
        return paymentMapper.getPaymentByTradeNo(tradeNo);
    }
}
