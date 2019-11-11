package com.wn.csd.view;

import com.wn.csd.domain.Car;
import com.wn.csd.domain.Order;
import com.wn.csd.service.CarService;
import com.wn.csd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author weining
 * @date 2019/11/11 16:34
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private CarService carService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/pay")
    @ResponseBody
    public Map<String,Object> CarOrder(Integer cid){
        Car car = carService.selectCarById(cid);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",1);
        map.put("info",car);
        return map;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(Order order, HttpSession session){
        System.out.println(order.getCid()+"123"+order.getGetId()+"456"+order.getBackId()+"789"+order.getOprice());
        order.setUid((Integer) session.getAttribute("UID"));

        orderService.addOrderById(order);

        return "1";
    }

}
