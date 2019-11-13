package com.wn.csd.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author weining
 * @date 2019/11/11 8:25
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    /**
     * 用户退出操作
     * @param req  获取session
     * @return 退出登录
     */
    @RequestMapping("quit")
    public String quit(HttpServletRequest req){
        req.getSession().removeAttribute("USERNAME");
        return "/pagehome/login";
    }

    /**
     * 用户跳转主页
     * @return 跳转到主页
     */
    @RequestMapping("/index")
    public String index(){
        return "/pagehome/index";
    }

    /**
     * 跳转登录页面操作
     * @return 返回到用户登录页面
     */
    @RequestMapping("/login")
    public String loginIn() {
        return "/pagehome/login";
    }

    /**
     * 跳转注册页面操作
     * @return 返回用户注册页面
     */
    @RequestMapping("/register")
    public String register(){
        return "/pagehome/register";
    }

    /**
     * 跳转选地址的页面
     * @return 跳转到shortrent页面
     */
    @RequestMapping("/short")
    public String Short(Model model){
        return "/shortRent/shortrent";
    }

    /**
     * 跳选车页面
     * @return 跳转选车页面
     */
    @RequestMapping("/car")
    public String car(){
        return "/shortRent/shortsort";
    }

    /**
     * 跳转选车成功的页面
     * @return 返回选车成功的页面
     */
    @RequestMapping("/order")
    public String order(){
        return "/order/ordersubmit";
    }

    /**
     * 跳转到我的订单页面
     * @return 返回我的订单
     */
    @RequestMapping("/myMain")
    public String myMain(){
        return "/mymain/mymain";
    }

    /**
     * 跳转到用户个人首页
     * @return 返回个人首页
     */
    @RequestMapping("/user")
    public String User(){
        return "/mymain/myinfo";
    }

    /**
     * 跳转到关于我们的页面
     * @return 跳转返回我们页面
     */
    @RequestMapping("/about")
    public String about(){
        return "/pagehome/about";
    }
}
