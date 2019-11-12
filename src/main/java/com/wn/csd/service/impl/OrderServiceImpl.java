package com.wn.csd.service.impl;

import com.wn.csd.domain.Order;
import com.wn.csd.domain.OrderPage;
import com.wn.csd.domain.UserOrder;
import com.wn.csd.mapper.OrderMapper;
import com.wn.csd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<UserOrder> selectAllOrder(OrderPage orderPage) {
        return orderMapper.selectAllOrder(orderPage);
    }

    public Integer selectTotal(Integer uid) {
        return orderMapper.selectTotal(uid);
    }
}
