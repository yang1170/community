//package com.newcoder.community;
//
//import com.newcoder.community.service.AlphaService;
//import com.newcoder.community.util.SensitiveFilter;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import com.newcoder.community.service.MailClientService;
//import com.newcoder.community.service.imp.MailClient;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.context.Context;
//
//@ContextConfiguration(classes = CommunityApplication.class)
//@SpringBootTest(classes = MailTests.class)
//@SpringBootApplication
//@RunWith(SpringRunner.class)
//
//public class SensitiveTests {
//
//    @Autowired
//    private SensitiveFilter sensitiveFilter;
//
//    @Test
//    public void testSensitiveFilter(){
//        String text="这里可以赌博，可以嫖娼，可以吸毒，可以开票";
//        text=sensitiveFilter.filter(text);
//        System.out.println(text);
//        System.out.println("++++++++++++++++++++++");
//        text="这里可以🀁赌博，可以🀂嫖娼，可以🀂🀂🀂吸毒，可以开🀃🀃🀃票";
//        text=sensitiveFilter.filter(text);
//        System.out.println(text);
//    }
//
//
//}
