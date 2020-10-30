package com.example.mapper;

import com.example.entities.Order;
import org.apache.ibatis.annotations.Param;


/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/29 17:58
 */
public interface OrderMapper {
    void create(Order order);

    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
