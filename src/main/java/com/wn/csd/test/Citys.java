package com.wn.csd.test;

import com.wn.csd.domain.City;
import com.wn.csd.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author weining
 * @date 2019/11/10 17:54
 */
public class Citys {
    @Autowired
    private static CityService cityService;
    public static void main(String[] args) {
        List<City> strings = cityService.selectCity(1);
        for (City city : strings) {
            System.out.println(city);
        }
    }
}
