package com.example.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/23 8:50
 */
@RestController
public class ConsumerOrderController {
    public static final Logger logger = LoggerFactory.getLogger(ConsumerOrderController.class);
    public static final String serviceUrl = "cloud-alibaba-provider-payment";

    @Resource
    LoadBalancerClient loadBalancerClient; // 负载均衡

    @GetMapping("/nacos/consumer/order/{id}")
    public String getOrder(@PathVariable("id") Integer id) {
        ServiceInstance serviceInstance = loadBalancerClient.choose(serviceUrl);
        String url = serviceInstance.getUri() + "/payment/nacos/" + id;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        logger.info(result);
        return result;
    }
}
