package com.wn.csd.mapper;

import com.wn.csd.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @author weining
 * @date 2019/11/8 16:12
 */
@Repository
public interface UserMapper {
    /**
     * 通过tel来查询数据，
     * 假如存在该数据，则通过tel查询到所有数据返回给controller层
     * @param tel 电话号
     * @return 返回User对象
     */
    User findUserByTel(String tel);

    void register(User user);

    void updateUser(User user);
}
