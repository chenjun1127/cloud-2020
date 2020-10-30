package com.example.service.impl;

import com.example.mapper.StorageMapper;
import com.example.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/30 10:06
 */
@Service
public class StorageServiceImpl implements StorageService {
    public static final Logger logger = LoggerFactory.getLogger(StorageServiceImpl.class);
    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        logger.info("storage-service中扣减库存");
        storageMapper.decrease(productId, count);
    }
}
