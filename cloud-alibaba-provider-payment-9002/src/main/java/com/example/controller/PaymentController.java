package com.example.controller;

import com.example.entities.Payment;
import com.example.utils.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/22 18:12
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/nacos/{id}")
    public String getPaymentById(@PathVariable("id") Integer id) {
        return "Nacos registry, server port: " + serverPort + ",id: " + id;
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Integer id) {
        Payment payment = createPaymentList().get(id);
        return new CommonResult<>(200, "from server port: " + serverPort, payment);
    }
    // 模拟数据库数据
    public static List<Payment> createPaymentList() {
        List<Payment> paymentList = new ArrayList<>();
        int i = 0;
        while (i < 3) {
            paymentList.add(new Payment((long) i, UUID.randomUUID().toString()));
            i++;
        }
        return paymentList;
    }
}
