package com.wn.csd.service.impl;

import com.wn.csd.domain.Order;
import com.wn.csd.mapper.OrderMapper;
import com.wn.csd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author weining
 * @date 2019/11/11 16:41
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public void addOrderById(Order order) {
        orderMapper.addOrderById(order);
    }
}
