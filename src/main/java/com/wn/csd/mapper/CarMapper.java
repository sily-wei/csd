package com.wn.csd.mapper;

import com.wn.csd.domain.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarMapper {
    List<Car> selectCarByCId(Integer getId);

    List<Car> selectCarByNumber(Integer getId);

    Car selectCarById(Integer cid);
}
