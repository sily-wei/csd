package com.wn.csd.view;

import com.wn.csd.domain.User;
import com.wn.csd.service.CityService;
import com.wn.csd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author weining
 * @date 2019/11/8 20:01
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CityService cityService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(User user, HttpSession session) {
        User user2 = userService.findUserByTel(user.getTel());

        if (user.getPassword().equals(user2.getPassword())) {
            session.setAttribute("UID",user2.getId());
            session.setAttribute("EMAIL",user2.getEmail());
            session.setAttribute("USERNAME", user.getTel());
            return "1";
        } else {
            return "2";
        }
    }

    @RequestMapping("/loginTel")
    @ResponseBody
    public Map<String,Object> loginTel(HttpSession session){
        Object username = session.getAttribute("USERNAME");
        User user = userService.findUserByTel((String) username);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",1);
        map.put("info",user);
        return map;
    }


    @RequestMapping("/loginSuccess")
    public String loginSuccess(Model model) {
        return "/pagehome/loginsuccess";
    }

    @RequestMapping("register")
    @ResponseBody
    public String registerUp(HttpSession session, User user) {
        String random = (String) session.getAttribute("R");
        User tel = userService.findUserByTel(user.getTel());
        if (tel.getTel() == null) {
            if (random.equals(user.getInvitation())) {
                userService.register(user);
                return "1";
            }
            else {
                return "2";
            }
        }else {
            return "3";
        }


    }

    @RequestMapping("/validateTel")
    @ResponseBody
    public String validateTel(String tel) {
        return "0";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(User user,HttpSession session){
        user.setId((Integer) session.getAttribute("UID"));
        userService.updateUser(user);
        return "1";
    }
}
