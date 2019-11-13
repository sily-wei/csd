package com.wn.csd.view;

import com.wn.csd.domain.Car;
import com.wn.csd.domain.City;
import com.wn.csd.service.CarService;
import com.wn.csd.service.CityService;
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

    /**
     * 获取租出地点和还车地点，通过map对象返回给前端页面
     * @param getId 租车地点的id
     * @param backId 还车地点的id
     * @return 将map对象返还给前端页面
     */
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

    /**
     * 通过租车地点的id 获取所有租地点所有的汽车，此时是按照number（热度）排序
     * @param getId 租车地点的id
     * @return 返回一个map对象给前端
     */
    @RequestMapping("/carList")
    @ResponseBody
    public Map<String, Object> carList(Integer getId) {
        List<Car> cars = carService.selectCarByNumber(getId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 1);
        map.put("info", cars);
        return map;
    }

    /**
     * 通过租车地点的id 获取所有租地点所有的汽车，此时是按照price（价钱）排序
     * @param getId 租车地点的id
     * @return 返回一个map对象给前端
     */
    @RequestMapping("/price")
    @ResponseBody
    public Map<String, Object> priceList(Integer getId) {
        List<Car> cars = carService.selectCarByCId(getId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 1);
        map.put("info", cars);
        return map;
    }

    /**
     * 跳转到order页面
     * @param cid 汽车的id
     * @return 返回map对象
     */
    @RequestMapping("/order")
    @ResponseBody
    public Map<String, Object> order(Integer cid) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 1);
        return map;
    }
}
