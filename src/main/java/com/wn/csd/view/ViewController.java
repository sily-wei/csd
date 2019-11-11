package com.wn.csd.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author weining
 * @date 2019/11/11 8:25
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    /**
     *
     * @param req  获取session
     * @return 退出登录
     */
    @RequestMapping("quit")
    public String quit(HttpServletRequest req){
        req.getSession().removeAttribute("USERNAME");
        return "/pagehome/login";
    }

    /**
     *
     * @return 跳转到主页
     */
    @RequestMapping("/index")
    public String index(){
        return "/pagehome/index";
    }

    /**
     * @return 返回到用户登录页面
     */
    @RequestMapping("/login")
    public String loginIn() {
        return "/pagehome/login";
    }

    /**
     * @return 返回发哦用户注册页面
     */
    @RequestMapping("/register")
    public String register(){
        return "/pagehome/register";
    }

    @RequestMapping("/car")
    public String car(){
        return "/shortRent/shortsort";
    }

    @RequestMapping("/order")
    public String order(){
        return "/order/ordersubmit";
    }

    @RequestMapping("/myMain")
    public String myMain(){
        return "/mymain/mymain";
    }

    @RequestMapping("/user")
    public String User(){
        return "/mymain/myinfo";
    }
}
