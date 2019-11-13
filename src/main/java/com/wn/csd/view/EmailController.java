package com.wn.csd.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * @author weining
 * @date 2019/11/11 8:32
 */
@Controller
@RequestMapping("/send")
public class EmailController {

    private static final Logger logger = LogManager.getLogger(EmailController.class);
    private static ApplicationContext applicationContext;
    private static JavaMailSender javaMailSender;
    private static String mailSender ;


    static {
        applicationContext = new ClassPathXmlApplicationContext("Spring/springEmail.xml");

        javaMailSender = (JavaMailSender) applicationContext.getBean("javaMailSender");


        mailSender ="2571736528@qq.com";

    }

    /**
     * 发送邮件
     * @param email 邮箱的id
     * @param session 将随机数放到session中，在注册页面通过session可以获取随机数，进行验证
     */
    @RequestMapping("/email")
    @ResponseBody
    public void registerUp(String email, HttpSession session){
        /**
         * 设置随机数
         */
        Random r = new Random();
        int i = r.nextInt(999999);
        if (i<100000){
            i+=100000;
        }
        String i2 = i+"";
        session.setAttribute("R",i2);
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            //邮件发送人
            simpleMailMessage.setFrom(mailSender);
            //邮件接收人
            simpleMailMessage.setTo(email);
            //邮件主题
            simpleMailMessage.setSubject("验证码");
            //邮件内容
            simpleMailMessage.setText("您的验证码是"+i2);
            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            logger.error("邮件发送失败", e);
        }
    }

}
