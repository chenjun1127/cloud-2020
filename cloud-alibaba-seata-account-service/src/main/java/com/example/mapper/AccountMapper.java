package com.example.mapper;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/30 10:27
 */
public interface AccountMapper {
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}

