package com.wn.csd.service;

import com.wn.csd.domain.Car;

import java.util.List;

/**
 * @author weining
 * @date 2019/11/8 19:20
 */
public interface CarService {
    /**
     * 通过价钱获取所有的车
     * @param getId 城市的id
     * @return 返回所有的车
     */
    List<Car> selectCarByCId(Integer getId);

    /**
     * 通过热度获取所有的车，并排序
     * @param getId 城市的id
     * @return 返回所有的车
     */
    List<Car> selectCarByNumber(Integer getId);

    /**
     * 通过cid，查询指定id的所有车
     * @param cid 汽车的id
     * @return 返回车的所有数据
     */
    Car selectCarById(Integer cid);
}
