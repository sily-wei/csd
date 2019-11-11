package com.wn.csd.mapper;

import com.wn.csd.domain.City;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityMapper {
    List<City> selectCity(Integer pid);

    City selectCityById(String getId);

}
