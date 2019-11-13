package com.wn.csd.service.impl;

import com.wn.csd.domain.Car;
import com.wn.csd.mapper.CarMapper;
import com.wn.csd.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weining
 * @date 2019/11/11 11:15
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    /**
     * 通过价钱获取所有的车
     * @param getId 城市的id
     * @return 返回所有的车
     */
    public List<Car> selectCarByCId(Integer getId) {
        return carMapper.selectCarByCId(getId);
    }

    /**
     * 通过热度获取所有的车，并排序
     * @param getId 城市的id
     * @return 返回所有的车
     */
    public List<Car> selectCarByNumber(Integer getId) {
        return carMapper.selectCarByNumber(getId);
    }

    /**
     * 通过cid，查询指定id的所有车
     * @param cid 汽车的id
     * @return 返回车的所有数据
     */
    public Car selectCarById(Integer cid) {
        return carMapper.selectCarById(cid);
    }
}
