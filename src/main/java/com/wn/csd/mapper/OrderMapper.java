package com.wn.csd.mapper;

import com.wn.csd.domain.Order;
import com.wn.csd.domain.OrderPage;
import com.wn.csd.domain.UserOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    /**
     * 添加订单
     * @param order 订单
     */
    void addOrderById(Order order);

    /**
     * 查询所有订单
     * @param orderPage 页面订单的实体类
     * @return 返回所有多的数据
     */
    List<UserOrder> selectAllOrder(OrderPage orderPage);

    /**
     * 通过uid 获取查询对应的uid的数据总条数
     * @param uid 用户id
     * @return 返回指定uid的总条数
     */
    Integer selectTotal(Integer uid);
}
