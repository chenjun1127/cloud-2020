package com.example.controller;

import com.example.service.AccountService;
import com.example.utils.CommonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/30 10:16
 */
@RestController
public class AccountController {
    @Resource
    private AccountService accountService;

    @RequestMapping("/account/decrease")
    public CommonResult<Object> decrease(@Param("userId") Long userId, @Param("money") BigDecimal money) {
        // 模拟超时
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountService.decrease(userId, money);
        return new CommonResult<>(200, "扣减账户余额成功");
    }
}
