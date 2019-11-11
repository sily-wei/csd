package com.wn.csd.utils;

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

    private static final Logger logger = LogManager.getLogger(com.wn.csd.test.EmailSend.class);

    private static ApplicationContext applicationContext;
    private static JavaMailSender javaMailSender;
    private static String mailSender ;


    static {
        applicationContext = new ClassPathXmlApplicationContext("spring1.xml");

        javaMailSender = (JavaMailSender) applicationContext.getBean("javaMailSender");

        Properties properties = new Properties();
        // 从配置文件中拿到发件人邮箱地址
        try {
            properties.load(com.wn.csd.test.EmailSend.class.getResourceAsStream("/properties/mail.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mailSender = properties.getProperty("spring.mail.username");
    }

    public static Logger getLogger() {
        return logger;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        EmailSend.applicationContext = applicationContext;
    }

    public static JavaMailSender getJavaMailSender() {
        return javaMailSender;
    }

    public static void setJavaMailSender(JavaMailSender javaMailSender) {
        EmailSend.javaMailSender = javaMailSender;
    }

    public static String getMailSender() {
        return mailSender;
    }

    public static void setMailSender(String mailSender) {
        EmailSend.mailSender = mailSender;
    }
}