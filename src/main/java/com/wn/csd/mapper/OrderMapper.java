package com.wn.csd.mapper;

import com.wn.csd.domain.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {
    void addOrderById(Order order);
}
