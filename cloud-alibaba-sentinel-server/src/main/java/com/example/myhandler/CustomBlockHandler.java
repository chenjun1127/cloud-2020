package com.example.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.entities.Payment;
import com.example.utils.CommonResult;

import java.util.UUID;

/**
 * @Description: 全局自定义兜底
 * @Author: chenjun
 * @Date: 2020/10/28 10:42
 */
public class CustomBlockHandler {
    public static CommonResult<Object> myHandlerException(BlockException exception) {
        return new CommonResult<>(444, "自定义：global handlerException", new Payment(2020L, UUID.randomUUID().toString()));
    }
}
