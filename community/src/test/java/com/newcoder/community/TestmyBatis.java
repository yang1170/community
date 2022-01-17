//package com.newcoder.community;
//
//import com.newcoder.community.dao.DiscussPostMapper;
//import com.newcoder.community.dao.LoginTicketMapper;
//import com.newcoder.community.dao.UserMapper;
//import com.newcoder.community.entity.DiscussPost;
//import com.newcoder.community.entity.LoginTicket;
//import com.newcoder.community.entity.User;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.util.Date;
//import java.util.List;
//
//
////@SpringBootTest
////@SpringBootApplication
////@MapperScan("com.newcoder.community.dao")
//
////@ContextConfiguration(classes = CommunityApplication.class)
////@MapperScan("com.newcoder.community.dao")
////@SpringBootApplication
//
//
//@SpringBootTest(classes = TestmyBatis.class)
//@SpringBootApplication
//
//public class TestmyBatis {
//    @Autowired
//    UserMapper userMapper;
//
//
//
//    @Test
//    public void testSelectUser() {
//        System.out.println(userMapper);
//        User user = userMapper.selectById(101);
//        System.out.println(user);
//        User user1 = userMapper.selectByName("liubei");
//        System.out.println(user1);
//        User user2 = userMapper.selectByEmail("nowcoder101@sina.com");
//        System.out.println(user2);
//
//    }
//    @Test
//    public void testInsertuser(){
//        User user = new User();
//        user.setUsername("test");
//        user.setPassword("123456");
//        user.setSalt("abc");
//        user.setEmail("text@qq.com");
//        user.setHeaderUrl("http:www.nowcoder.com/101.png");
//        user.setCreateTime(new Date());
//        int i = userMapper.insertUser(user);
//        System.out.println(i);
//        System.out.println(user.getId());
//
//    }
//    @Test
//    public void update(){
//        int rows = userMapper.updateStatus(150,1);
//        System.out.println(rows);
//    }
////   @org.junit.Test
////    public void testSelectPost(){
////        System.out.println(discussPostMapper);
////        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(0, 0, 10);
////        for (DiscussPost post:discussPosts){
////            System.out.println(post);
////        }
//    @Autowired
//    DiscussPostMapper discussPostMapper;
//    @Test
//    public void SelectPost(){
//        System.out.println(discussPostMapper);
//       List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0,0,10);
//        for (DiscussPost post:list){
//            System.out.println(post);
//        }
//        int row = discussPostMapper.selectDiscussPostRows(0);
//        System.out.println(row);
//    }
//    @Autowired
//    private LoginTicketMapper loginTicketMapper;
//    @Test
//    public void testInsertLoginTick(){
//        LoginTicket loginTicket = new LoginTicket();
//        loginTicket.setId(101);
//        loginTicket.setTicket("abc");
//        loginTicket.setStatus(0);
//        loginTicket.setExpired(new Date(System.currentTimeMillis()+1000*60*18));
//        loginTicketMapper.insertLoginTicket(loginTicket);
//    }
//    @Test
//    public void selectLoginTicket(){
//        LoginTicket loginTicket = loginTicketMapper.selectByTicket("abc");
//        System.out.println(loginTicket);
//        loginTicketMapper.updateStatus("abc",1);
//        loginTicket = loginTicketMapper.selectByTicket("abc");
//        System.out.println(loginTicket);
//    }
//}
//
//
//
//
//
