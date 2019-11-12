package com.wn.csd.service;

import com.wn.csd.domain.Order;
import com.wn.csd.domain.OrderPage;
import com.wn.csd.domain.UserOrder;

import java.util.List;

/**
 *
 */
public interface OrderService {

    void addOrderById(Order order);

    List<UserOrder> selectAllOrder(OrderPage orderPage);

    Integer selectTotal(Integer uid);
}
