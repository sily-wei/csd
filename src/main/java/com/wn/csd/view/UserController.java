package com.wn.csd.view;

import com.wn.csd.domain.User;
import com.wn.csd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author weining
 * @date 2019/11/8 20:01
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/loginIn")
    public String loginIn() {
        System.out.println("123");
        return "/pagehome/login";
    }


    @RequestMapping("/login")
    public String login(User user, Model model) {

        User userByTel = userService.findUserByTel(user.getTel());

        if (user.getPassword()==userByTel.getPassword()){
            return "/pagehome/loginsuccess";
        }else {
            String msg = "账号或者密码错误";
            model.addAttribute("msg",msg);
            return "/pagehome/login";
        }

    }

}
