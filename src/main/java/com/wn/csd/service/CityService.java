package com.wn.csd.service;

import com.wn.csd.domain.City;

import java.util.List;

public interface CityService {
    List<City> selectCity(Integer pid);

    City selectCityById(String getId);
}
