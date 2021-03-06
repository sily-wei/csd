package com.wn.csd.service.impl;

import com.wn.csd.domain.User;
import com.wn.csd.mapper.UserMapper;
import com.wn.csd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author weining
 * @date 2019/11/8 19:20
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 通过tel来查询数据，
     * 假如存在该数据，则通过tel查询到所有数据返回给controller层
     * @param tel 电话号
     * @return 返回User对象
     */
    @Transactional
    public User findUserByTel(String tel) {
        System.out.println(tel);
        return userMapper.findUserByTel(tel);
    }

    /**
     * 注册用户
     * @param user 用户的实体类
     */
    @Transactional
    public void register(User user) {
        userMapper.register(user);
    }

    /**
     * 修改用户
     * @param user 用户的实体类
     */
    @Transactional
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
