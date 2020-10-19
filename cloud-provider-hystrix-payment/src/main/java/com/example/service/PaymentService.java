package com.example.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/19 10:58
 */
@Service
public class PaymentService {
    public String paymentInfoOk(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfoOk,id:" + id;
    }
    // 超时服务降级
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoTimeOut(Integer id) {
        // 超时
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfoTimeOut,id:" + id + "耗时 " + timeNumber;
    }

    /*
     * @Description: 兜底数据
     * @Param: [id]
     * @Return: java.lang.String
     */
    public String paymentInfoTimeOutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "服务繁忙或运行出错，请稍后再试 , paymentInfoTimeOutHandler,id:" + id;
    }
}
