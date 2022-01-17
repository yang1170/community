package com.newcoder.community.dao;

import com.newcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
//    分页查询
//    首页查询是不用查userId，个人主页 是查询个人的帖子的时候，是加上这个
//    当userId是0的时候 不进行拼接，如果不是0，实现动态sql进行拼接
    List<DiscussPost> selectDiscussPosts( int userId,  int offset, int limit);
//    需要知道一共有多少页，两个条件多少条数据，每页多少数据。
//    @Param("userId")给参数进行别名，如需动态的拼接一个sql。而且方法有且只有一个条件，就进行别名设置

    int selectDiscussPostRows(@Param("userId") int userId);

//增加帖子的方法
//发布帖子
    int insertDiscussPost(DiscussPost discussPost);
    //帖子详情
    DiscussPost selectDiscussPostById(int id);

    int updateCommentCount(int id, int commentCount);

}
