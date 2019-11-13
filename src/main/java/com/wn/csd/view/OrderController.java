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

    /**
     * 支付界面，通过cid获取汽车的详情
     * @param cid 汽车的id
     * @return 将汽车和code以map对象的形式，返回到前端页面
     */
    @RequestMapping("/pay")
    @ResponseBody
    public Map<String,Object> CarOrder(Integer cid){
        Car car = carService.selectCarById(cid);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",1);
        map.put("info",car);
        return map;
    }

    /**
     * 将用户选的车放到订单中
     * @param order 订单信息
     * @param session 获取用户的uid
     * @return 返回一个map对象用来作为放到订单的依据
     */
    @RequestMapping("/add")
    @ResponseBody
    public Map<String, Object> add(Order order, HttpSession session){
        order.setUid((Integer) session.getAttribute("UID"));

        orderService.addOrderById(order);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",1);
        return map;
    }

    /**
     * 将用户的所有订单都传给前端页面
     * @param page 页码数
     * @param session 获取uid
     * @return 返回json数据 给前端
     */
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
