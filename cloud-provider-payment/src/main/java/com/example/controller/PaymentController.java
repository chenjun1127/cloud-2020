package com.example.controller;

import com.example.entities.Payment;
import com.example.service.PaymentService;
import com.example.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description: payment controller
 * @Author: chenjun
 * @Date: 2020/10/14 17:29
 */
@Slf4j
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/save")
    public CommonResult<Object> createPayment(@RequestBody Payment payment) {
        String tradeNo = payment.getTradeNo();
        Payment py = paymentService.getPaymentByTradeNo(tradeNo);
        if (py != null && py.getTradeNo().equals(tradeNo)) {
            return new CommonResult<>(-1, "请勿重复插入数据", null);
        }
        int result = paymentService.create(payment);
        if (result > 0) {
            log.info("插入数据成功");
            return new CommonResult<>(0, "插入数据成功");
        } else {
            return new CommonResult<>(-1, "插入数据失败", null);
        }
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Object> getPaymentById(@PathVariable("id") Long id) {
        log.info("获取数据成功");
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) return new CommonResult<>(0, "查询成功", payment);
        return new CommonResult<>(-1, "查询失败", null);
    }
}
