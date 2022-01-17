//package com.newcoder.community;
//
//
//import com.newcoder.community.dao.DiscussPostMapper;
//import com.newcoder.community.dao.LoginTicketMapper;
//import com.newcoder.community.dao.MessageMapper;
//import com.newcoder.community.dao.UserMapper;
//import com.newcoder.community.entity.DiscussPost;
//import com.newcoder.community.entity.LoginTicket;
//import com.newcoder.community.entity.Message;
//import com.newcoder.community.entity.User;
//import com.newcoder.community.service.MailClientService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.context.Context;
//
//import java.util.Date;
//import java.util.List;
//
//@ContextConfiguration(classes = CommunityApplication.class)
//@SpringBootTest(classes = MailTests.class)
//@SpringBootApplication
//@RunWith(SpringRunner.class)
//public class MailTests extends CommunityApplication {
//    @Autowired
//    public MailClientService mailClient;
//    @Autowired
//    private TemplateEngine templateEngine;
//
//    @Test
//    public void testMail() {
//        System.out.println(mailClient+"1");
//        mailClient.senMail("17865563727@163.com","happy","国庆快乐");
//    }
//    @Test
//    public void testHtml(){
//        Context context = new Context();
//        context.setVariable("username","xiaojia");
//        String process = templateEngine.process("/mail/demo", context);
//        mailClient.senMail("17865563727@163.com","happy",process);
//
//    }
//
//    @Autowired
//    private MessageMapper messageMapper;
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private DiscussPostMapper discussPostMapper;
//
//    @Autowired
//    private LoginTicketMapper loginTicketMapper;
//    @Test
//    public void testSelectUser() {
//        User user = userMapper.selectById(101);
//        System.out.println(user);
//
//        user = userMapper.selectByName("liubei");
//        System.out.println(user);
//
//        user = userMapper.selectByEmail("nowcoder101@sina.com");
//        System.out.println(user);
//    }
//
//    @Test
//    public void testInsertUser() {
//        User user = new User();
//        user.setUsername("test");
//        user.setPassword("123456");
//        user.setSalt("abc");
//        user.setEmail("test@qq.com");
//        user.setHeaderUrl("http://www.nowcoder.com/101.png");
//        user.setCreateTime(new Date());
//
//        int rows = userMapper.insertUser(user);
//        System.out.println(rows);
//        System.out.println(user.getId());
//    }
//
//    @Test
//    public void updateUser() {
//        int rows = userMapper.updateStatus(150, 1);
//        System.out.println(rows);
//
//        rows = userMapper.updateHeader(150, "http://www.nowcoder.com/102.png");
//        System.out.println(rows);
//
//        rows = userMapper.updatePassword(150, "hello");
//        System.out.println(rows);
//    }
//
//    @Test
//    public void testSelectPosts() {
//        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(111, 0, 20);
//        for (DiscussPost post : list) {
//            System.out.println(post);
//        }
//
//        int rows = discussPostMapper.selectDiscussPostRows(111);
//        System.out.println(rows);
//    }
//
//    @Test
//    public void testInsertLoginTicket() {
//        LoginTicket loginTicket = new LoginTicket();
//        loginTicket.setUserId(101);
//        loginTicket.setTicket("abc");
//        loginTicket.setStatus(0);
//        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000 * 60 * 10));
//
//        loginTicketMapper.insertLoginTicket(loginTicket);
//    }
//
//    @Test
//    public void testSelectLoginTicket() {
//        LoginTicket loginTicket = loginTicketMapper.selectByTicket("abc");
//        System.out.println(loginTicket);
//
//        loginTicketMapper.updateStatus("abc", 1);
//        loginTicket = loginTicketMapper.selectByTicket("abc");
//        System.out.println(loginTicket);
//    }
//
//    @Test
//    public void testSelectLetters() {
//        List<Message> list = messageMapper.selectConversations(111, 0, 20);
//        for (Message message : list) {
//            System.out.println(message);
//        }
//
//        int count = messageMapper.selectConversationCount(111);
//        System.out.println(count);
//
//        list = messageMapper.selectLetters("111_112", 0, 10);
//        for (Message message : list) {
//            System.out.println(message);
//        }
//
//        count = messageMapper.selectLetterCount("111_112");
//        System.out.println(count);
//
//        count = messageMapper.selectLetterUnreadCount(131, "111_131");
//        System.out.println(count);
//
//    }
//
//
//}
