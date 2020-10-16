package com.example.controller;

import com.example.entities.Payment;
import com.example.service.PaymentFeignService;
import com.example.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/16 15:04
 */
@RestController
@RequestMapping("consumer/openfeign")
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @PostMapping("/payment/save")
    public CommonResult<Object> save(@RequestBody Payment payment) {
        System.out.println(payment);
        return paymentFeignService.createPayment(payment);
    }
}
