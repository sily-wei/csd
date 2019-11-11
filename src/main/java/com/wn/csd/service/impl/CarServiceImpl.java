package com.wn.csd.service.impl;

import com.wn.csd.domain.Car;
import com.wn.csd.mapper.CarMapper;
import com.wn.csd.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

/**
 * @author weining
 * @date 2019/11/11 11:15
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    public List<Car> selectCarByCId(Integer getId) {
        return carMapper.selectCarByCId(getId);
    }

    public List<Car> selectCarByNumber(Integer getId) {
        return carMapper.selectCarByNumber(getId);
    }

    public Car selectCarById(Integer cid) {
        return carMapper.selectCarById(cid);
    }
}
