package com.wn.csd.service;

import com.wn.csd.domain.Car;

import java.util.List;

public interface CarService {
    List<Car> selectCarByCId(Integer getId);

    List<Car> selectCarByNumber(Integer getId);

    Car selectCarById(Integer cid);
}
