package com.example.controller;

import com.example.service.StorageService;
import com.example.utils.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/30 10:09
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonResult<Object> decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult<>(200, "库存扣减成功");
    }
}
