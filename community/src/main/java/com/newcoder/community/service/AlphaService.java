package com.newcoder.community.service;

import com.newcoder.community.dao.AlphaDao;
import com.newcoder.community.dao.DiscussPostMapper;
import com.newcoder.community.dao.UserMapper;
import com.newcoder.community.entity.DiscussPost;
import com.newcoder.community.entity.User;
import com.newcoder.community.util.CommunityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;

@Service
//@Scope("prototype")
public class AlphaService {

    @Autowired
    private AlphaDao alphaDao;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private TransactionTemplate transactionTemplate;
    public AlphaService() {
//        System.out.println("实例化AlphaService");
    }

    @PostConstruct
    public void init() {
//        System.out.println("初始化AlphaService");
    }

    @PreDestroy
    public void destroy() {
//        System.out.println("销毁AlphaService");
    }

    public String find() {
        return alphaDao.select();
    }
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Object save1() {
        // 新增用户
        User user = new User();
        user.setUsername("alpha");
        user.setSalt(CommunityUtil.generateUUid().substring(0, 5));
        user.setPassword(CommunityUtil.md5("123" + user.getSalt()));
        user.setEmail("alpha@qq.com");
        user.setHeaderUrl("http://image.nowcoder.com/head/99t.png");
        user.setCreateTime(new Date());
        userMapper.insertUser(user);

        // 新增帖子
        DiscussPost post = new DiscussPost();
        post.setUserId(user.getId());
        post.setTitle("Hello new world");
        post.setContent("新人报道!我来了");
        post.setCreateTime(new Date());
        discussPostMapper.insertDiscussPost(post);

        Integer.valueOf("abc");

        return "ok";
    }
    public Object save2() {
        transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        return transactionTemplate.execute(new TransactionCallback<Object>() {


            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                //新增用户
                User user = new User();
                user.setUsername("testA");
                user.setSalt(CommunityUtil.generateUUid().substring(0, 5));
                user.setPassword(CommunityUtil.md5("123" + user.getSalt()));
                user.setEmail("testA@qq.com");
                user.setHeaderUrl("http://image.nowcoder.com/head/99t.png");
                user.setCreateTime(new Date());
                userMapper.insertUser(user);
                //新增帖子
                DiscussPost post = new DiscussPost();
                post.setUserId(user.getId());
                post.setTitle("helloA");
                post.setContent("新人报道A");
                post.setCreateTime(new Date());
                discussPostMapper.insertDiscussPost(post);

                Integer.valueOf("abc");
                return "ok";
            }
        });
    }

}

    // REQUIRED: 支持当前事务(外部事务),如果不存在则创建新事务.
    // REQUIRES_NEW: 创建一个新事务,并且暂停当前事务(外部事务).
    // NESTED: 如果当前存在事务(外部事务),则嵌套在该事务中执行(独立的提交和回滚),否则就会REQUIRED一样.

