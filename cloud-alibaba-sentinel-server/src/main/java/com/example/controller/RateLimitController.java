package com.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.entities.Payment;
import com.example.myhandler.CustomBlockHandler;
import com.example.utils.CommonResult;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Description: sentinel默认会返回xml格式，因此要指定produces
 * @Author: chenjun
 * @Date: 2020/10/28 9:25
 */
@RestController
@RequestMapping(value = "sentinel", produces = MediaType.APPLICATION_JSON_VALUE)
public class RateLimitController {
    /*
     * @Description: 按资源名称限流测试，blockHandler兜底
     * @Param: []
     * @Return: com.example.utils.CommonResult<java.lang.Object>
     */
    @GetMapping(value = "/byResource")
    @SentinelResource(blockHandler = "handleException", value = "byResource")
    public CommonResult<Object> byResource() {
        return new CommonResult<>(200, "按资源名称限流测试OK", new Payment(2020L, UUID.randomUUID().toString()));
    }

    public CommonResult<Object> handleException(BlockException exception) {
        return new CommonResult<>(400, exception.getClass().getCanonicalName() + "\t服务不可用");
    }

    /*
     * @Description: 按url限流，没有blockHandler 会使用系统自带的
     * @Param: []
     * @Return: com.example.utils.CommonResult<java.lang.Object>
     */
    @GetMapping(value = "/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult<Object> byUrl() {
        return new CommonResult<>(200, "按url限流测试OK", new Payment(2020L, UUID.randomUUID().toString()));
    }

    /*
     * @Description: 自定义限流
     * @Param: []
     * @Return: com.example.utils.CommonResult<java.lang.Object>
     */
    @GetMapping(value = "/customBlockHandler")
    @SentinelResource(value = "customBlockHandler", blockHandlerClass = CustomBlockHandler.class, blockHandler = "myHandlerException")
    public CommonResult<Object> customBlockHandler() {
        return new CommonResult<>(200, "按自定义限流测试OK", new Payment(2020L, UUID.randomUUID().toString()));
    }
}
