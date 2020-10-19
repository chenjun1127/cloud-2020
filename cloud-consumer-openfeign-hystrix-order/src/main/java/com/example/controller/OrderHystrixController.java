package com.example.controller;

import com.example.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 消费者客户端，调支付服务
 * @Author: chenjun
 * @Date: 2020/10/19 13:44
 */
@RestController
@DefaultProperties(defaultFallback = "globalFallback")
@RequestMapping("/consumer")
public class OrderHystrixController {
    @Autowired
    PaymentHystrixService paymentHystrixService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") int id) {
        return paymentHystrixService.paymentInfoOk(id);
    }

//    @HystrixCommand(fallbackMethod = "paymentInfoFallback", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfoTimeOut(@PathVariable("id") int id) {
        return paymentHystrixService.paymentInfoTimeOut(id);
    }

    public String paymentInfoFallback(@PathVariable("id") int id) {
        return "我是消费者，对方支付系统繁忙请10秒后再试或者自己运行出错请检查自己！";
    }
    /*
     * @Description: 全局fallback，没有指定的就会用全局的
     * @Param: []
     * @Return: java.lang.String
     */
    public String globalFallback(){
        return "服务异常，请稍后重试！";
    }
}
