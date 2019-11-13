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

    /**
     * 登录验证，用来判断用户名，密码是否正确
     * @param user 用户实体类
     * @param session 将数据放到session中
     * @return 返回 1 或 2 作为是否成功的依据
     */
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

    /**
     * 通过用户的电话，找到对应的用户
     * @param session 获取用户的名字
     * @return 返回一个map对象
     */
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

    /**
     * 当你登录成功之后，会跳转首页
     * @return 通过视图解析器，直接跳转页面
     */
    @RequestMapping("/loginSuccess")
    public String loginSuccess() {
        return "/pagehome/loginsuccess";
    }

    /**
     * 用户注册页面
     * @param session 将验证码放到session中，判断验证码和用户输入的是否相同
     * @param user 用户实体类
     * @return 返回一个map对象，作为判断是否注册成功的依据
     */
    @RequestMapping("register")
    @ResponseBody
    public Map<String,Object> registerUp(HttpSession session, User user) {
        String random = (String) session.getAttribute("R");
        User userByTel = userService.findUserByTel(user.getTel());

        Map<String,Object> map = new HashMap<String, Object>();

        if (userByTel == null) {
            if (random.equals(user.getInvitation())) {
                userService.register(user);
                map.put("code",1);
                return map;
            }
            else {
                map.put("code",2);
                return map;
            }
        }else {
            System.out.println(789);
            map.put("code",3);
            return map;
        }
    }

    /**
     * 用户修改，通过获取用户的手机号，邮箱，密码，放到数据库中 进行修改操作
     * @param user  用户实体类
     * @param session session对象 拿到用户的uid，来修改对应uid的数据
     * @return 返回一个修改成功的状态码
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(User user,HttpSession session){
        user.setId((Integer) session.getAttribute("UID"));
        userService.updateUser(user);
        return "1";
    }
}
