package com.example.service.impl;

import com.example.mapper.AccountMapper;
import com.example.service.AccountService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/30 10:18
 */
@Service
public class AccountServiceImpl implements AccountService {
    public static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Resource
    private AccountMapper accountMapper;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        logger.info("account-service扣减账户余额");
        accountMapper.decrease(userId, money);
    }
}
