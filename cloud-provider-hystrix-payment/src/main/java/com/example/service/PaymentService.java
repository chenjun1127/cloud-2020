package com.example.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
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

    // ===================服务降级=======================
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

    // ===================服务熔断=======================
    // 服务先降级---》熔断，服务不可用---》服务慢慢可用
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否启用熔断器，默认是true。
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数，默认20
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 半开试探休眠时间，默认5000ms
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), // 错误百分比，默认值50%
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID(); // ==UUID.randomUUID().toString()
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号:" + serialNumber;
    }

    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id) {
        return "id不能为负数，请稍后再试！id:" + id;
    }
}
