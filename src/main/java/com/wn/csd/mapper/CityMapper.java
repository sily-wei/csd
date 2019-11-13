package com.wn.csd.mapper;

import com.wn.csd.domain.City;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityMapper {

    /**
     * 通过pid获取所有的城市名
     * @param pid 城市id
     * @return 返回所有pid对应的城市
     */
    List<City> selectCity(Integer pid);

    /**
     * 通过获取getid来查询对应的城市名字
     */
    City selectCityById(String getId);

}
