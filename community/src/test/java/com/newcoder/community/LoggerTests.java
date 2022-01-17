//package com.newcoder.community;
//
//
//import com.newcoder.community.service.imp.MailClient;
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//
//
////@SpringBootApplication
////@MapperScan("com.newcoder.community.dao")
//
//
////@RunWith(SpringRunner.class)
//
//@ContextConfiguration(classes = CommunityApplication.class)
//@SpringBootTest(classes = LoggerTests.class)
//@SpringBootApplication
//public class LoggerTests {
//    private static  final Logger logger = LoggerFactory.getLogger(LoggerTests.class);
//    @Test
//    public void testLogger(){
//        System.out.println(logger.getName());
//        logger.debug("debug log");
//        logger.info("debug log");
//        logger.warn("warn log");
//        logger.error("error log");
//    }
//    @Autowired
//    private MailClient mailClient;
//    @Test
//    public void testMail(){
//        System.out.println(mailClient);
////        mailClient.sendMail("17865563727@163.com","Test","WELCOME");
//    }
//}
