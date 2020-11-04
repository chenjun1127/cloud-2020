package com.example.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/30 9:56
 */
public interface StorageMapper {
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}

