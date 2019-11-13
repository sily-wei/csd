package com.wn.csd.service.impl;

import com.wn.csd.domain.Order;
import com.wn.csd.domain.OrderPage;
import com.wn.csd.domain.UserOrder;
import com.wn.csd.mapper.OrderMapper;
import com.wn.csd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author weining
 * @date 2019/11/11 16:41
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 添加订单
     * @param order 订单
     */
    @Transactional
    public void addOrderById(Order order) {
        orderMapper.addOrderById(order);
    }

    /**
     * 查询所有订单
     * @param orderPage 页面订单的实体类
     * @return 返回所有多的数据
     */
    @Transactional
    public List<UserOrder> selectAllOrder(OrderPage orderPage) {
        return orderMapper.selectAllOrder(orderPage);
    }

    /**
     * 通过uid 获取查询对应的uid的数据总条数
     * @param uid 用户id
     * @return 返回指定uid的总条数
     */
    @Transactional
    public Integer selectTotal(Integer uid) {
        return orderMapper.selectTotal(uid);
    }
}
