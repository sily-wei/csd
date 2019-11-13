package com.wn.csd.service.impl;

import com.wn.csd.domain.City;
import com.wn.csd.mapper.CityMapper;
import com.wn.csd.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 通过pid获取所有的城市名
     * @param pid 城市id
     * @return 返回所有pid对应的城市
     */
    public List<City> selectCity(Integer pid) {
        return cityMapper.selectCity(pid);
    }

    /**
     * 通过获取getid来查询对应的城市名字
     */
    public City selectCityById(String getId) {
        return cityMapper.selectCityById(getId);
    }
}
