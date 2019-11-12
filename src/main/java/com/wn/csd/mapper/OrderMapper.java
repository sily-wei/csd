package com.wn.csd.mapper;

import com.wn.csd.domain.Order;
import com.wn.csd.domain.OrderPage;
import com.wn.csd.domain.UserOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    void addOrderById(Order order);

    List<UserOrder> selectAllOrder(OrderPage orderPage);

    Integer selectTotal(Integer uid);
}
