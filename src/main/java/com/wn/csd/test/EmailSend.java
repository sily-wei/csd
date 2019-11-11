package com.wn.csd.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.io.IOException;
import java.util.Properties;

/**
 * 直接发送邮件
 */
public class EmailSend {

    private static final Logger logger = LogManager.getLogger(EmailSend.class);

    private static ApplicationContext applicationContext;
    private static JavaMailSender javaMailSender;
    private static String mailSender ;


    static {
        applicationContext = new ClassPathXmlApplicationContext("Spring/springEmail.xml");

        javaMailSender = (JavaMailSender) applicationContext.getBean("javaMailSender");


        mailSender ="2571736528@qq.com";
    }

    public static void main(String[] args) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            //邮件发送人
            simpleMailMessage.setFrom(mailSender);
            //邮件接收人
            simpleMailMessage.setTo("2571736528@qq.com");
            //邮件主题
            simpleMailMessage.setSubject("测试JavaMail");
            //邮件内容
            simpleMailMessage.setText("测试JavaMail");
            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            logger.error("邮件发送失败", e);
        }
        System.out.println("Hello World!");
    }
}
