package com.wn.csd.view;

import com.wn.csd.domain.City;
import com.wn.csd.service.CityService;
import com.wn.csd.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author weining
 * @date 2019/11/11 8:24
 */
@Controller
@RequestMapping("/rent")
public class RentController {

    @Autowired
    private CityService cityService;

    @RequestMapping("/select")
    @ResponseBody
    public String findByCityName(Integer pid){
        List<City> cities = cityService.selectCity(pid);
        return JsonUtils.objectToJson(cities);
    }

}
