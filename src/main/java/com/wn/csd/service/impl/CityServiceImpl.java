package com.wn.csd.service.impl;

import com.wn.csd.domain.City;
import com.wn.csd.mapper.CityMapper;
import com.wn.csd.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weining
 * @date 2019/11/10 17:09
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    public List<City> selectCity(Integer pid) {
        return cityMapper.selectCity(pid);
    }

    public City selectCityById(String getId) {
        return cityMapper.selectCityById(getId);
    }
}
