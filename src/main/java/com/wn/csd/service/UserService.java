package com.wn.csd.service;

import com.wn.csd.domain.User;

/**
 * @author weining
 * @date 2019/11/8 19:20
 */
public interface UserService {

    /**
     * 通过tel来查询数据，
     * 假如存在该数据，则通过tel查询到所有数据返回给controller层
     * @param tel 电话号
     * @return 返回User对象
     */
    User findUserByTel(String tel);

    /**
     * 注册用户
     * @param user 用户的实体类
     */
    void register(User user);

    /**
     * 修改用户
     * @param user 用户的实体类
     */
    void updateUser(User user);
}
