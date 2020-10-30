package com.example.service;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/30 10:16
 */
public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
