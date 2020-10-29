package com.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.entities.Payment;
import com.example.utils.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/23 8:50
 */
@RestController
@RequestMapping(value = "/sentinel", produces = MediaType.APPLICATION_JSON_VALUE)
public class CircleBreakerController {
    public static final Logger logger = LoggerFactory.getLogger(CircleBreakerController.class);
    public static final String SERVICE_URL = "http://cloud-alibaba-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    /*
     * @Description: fallback 管业务，blockHandler管配置违规
     * @Param: [id]
     * @Return: com.example.utils.CommonResult<com.example.entities.Payment>
     */
    @RequestMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback", fallback = "fallbackHandler")
    public CommonResult<Payment> fallback(@PathVariable Integer id) {
        logger.info("负载均衡与sentinel服务熔断，ID为：" + id);
        if (id < 0 || id > 2) {
            throw new IllegalArgumentException("非法参数异常");
        }
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/payment/get/" + id, CommonResult.class);
        return result;
    }

    public CommonResult<Payment> fallbackHandler(@PathVariable("id") Integer id, Throwable throwable) {
        return new CommonResult<Payment>(400, "兜底异常fallbackHandler, exception内容为" + throwable.getMessage(), new Payment(Long.parseLong(String.valueOf(id)), null));
    }
}
