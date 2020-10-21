package com.example.filter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @Description: 网关自定义过滤器
 * @Author: chenjun
 * @Date: 2020/10/21 10:53
 */
@Component
public class MyFilterGateway implements GlobalFilter, Ordered {
    Logger logger = LoggerFactory.getLogger(MyFilterGateway.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Come in MyLogFilterGateway: " + new Date());
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (StringUtils.isBlank(username)) {
            logger.info("用户名为空，非法用户!╥﹏╥...");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
