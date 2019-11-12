package com.wn.csd.view;

import com.wn.csd.domain.Car;
import com.wn.csd.domain.Order;
import com.wn.csd.domain.OrderPage;
import com.wn.csd.domain.UserOrder;
import com.wn.csd.service.CarService;
import com.wn.csd.service.OrderService;
import com.wn.csd.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
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
    public Map<String, Object> add(Order order, HttpSession session){
        order.setUid((Integer) session.getAttribute("UID"));

        orderService.addOrderById(order);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",1);
        return map;
    }

    @RequestMapping("/all")
    @ResponseBody
    public String all(Integer page,HttpSession session){
        Integer uid = (Integer) session.getAttribute("UID");
        int total = orderService.selectTotal(uid);

        OrderPage orderPage = new OrderPage();
        orderPage.setPage(page);
        orderPage.setPageSize(5);
        orderPage.setStartIndex((orderPage.getPage()-1)*5);
        orderPage.setUid(uid);

        List<UserOrder> userOrders = orderService.selectAllOrder(orderPage);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",1);
        map.put("info",userOrders);
        map.put("pages",total);
        return JsonUtils.objectToJson(map);
    }
}
