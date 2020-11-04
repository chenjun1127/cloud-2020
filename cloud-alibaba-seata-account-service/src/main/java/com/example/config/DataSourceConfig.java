package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/11/4 10:47
 */
@Configuration
public class DataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Primary
    @Bean("dataSource")
    public DataSource dataSource(DataSource druidDataSource) {
        return new io.seata.rm.datasource.DataSourceProxy(druidDataSource);
    }
}
