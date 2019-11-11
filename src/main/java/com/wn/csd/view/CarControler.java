package com.wn.csd.view;

import com.wn.csd.domain.Car;
import com.wn.csd.domain.City;
import com.wn.csd.service.CarService;
import com.wn.csd.service.CityService;
import com.wn.csd.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weining
 * @date 2019/11/11 10:21
 */
@RequestMapping("/car")
@Controller
public class CarControler {

    @Autowired
    private CarService carService;
    @Autowired
    private CityService cityService;

    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> list(String getId, String backId) {

        City city = cityService.selectCityById(getId);

        City city2 = cityService.selectCityById(backId);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("code", 1);
        map.put("info", city);
        map.put("info2", city2);
        return map;
    }

    @RequestMapping("/carList")
    @ResponseBody
    public Map<String, Object> carList(Integer getId) {
        List<Car> cars = carService.selectCarByNumber(getId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 1);
        map.put("info", cars);
        return map;
    }

    @RequestMapping("/price")
    @ResponseBody
    public Map<String, Object> priceList(Integer getId) {
        List<Car> cars = carService.selectCarByCId(getId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 1);
        map.put("info", cars);
        return map;
    }

    @RequestMapping("/order")
    @ResponseBody
    public Map<String, Object> order(Integer cid) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 1);
        return map;
    }
}
