package com.wn.csd.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author weining
 * @date 2019/11/12 20:28
 */
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 配置要拦截和要释放的数据
     * @param request request
     * @param response response
     * @param handler 配置释放的
     * @return 释放或者拦截
     * @throws Exception 抛出异常
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求的url
        String url = request.getRequestURI();
        //判断url是否为公开地址（实际使用时需要配置在配置文件中)
        //这里公开地址就是登录的地址
        if(url.indexOf("login")>=0){
            //如果是登录提交，则放行
            return true;
        }
        if(url.indexOf("resources")>=0){
            //如果是登录提交，则放行
            return true;
        }
        if(url.indexOf("index")>=0){
            //如果是登录提交，则放行
            return true;
        }
        if(url.indexOf("short")>=0){
            //如果是登录提交，则放行
            return true;
        }
        if(url.indexOf("car")>=0){
            //如果是登录提交，则放行
            return true;
        }
        if(url.indexOf("rent")>=0){
            //如果是登录提交，则放行
            return true;
        }
        if(url.indexOf("about")>=0){
            return true;
        }
        if(url.indexOf("register")>=0){
            //如果是登录提交，则放行
            return true;
        }
        if(url.indexOf("send")>=0){
            return true;
        }


        //判断session
        HttpSession session = request.getSession();
        //从session中取出用户身份信息
        String username = (String)session.getAttribute("USERNAME");
        if(username != null ){
            //身份存在session 放行
            return true;
        }
        //执行至此，表示用户身份需要认证，就跳转至登录页面
        request.getRequestDispatcher("/WEB-INF/pagehome/login.jsp").forward(request,response);
        //return false 表示拦截，不向下执行
        return false;
    }
}
