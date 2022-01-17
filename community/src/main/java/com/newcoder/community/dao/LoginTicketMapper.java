package com.newcoder.community.dao;

import com.newcoder.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

@Mapper
@Deprecated
public interface LoginTicketMapper {
//   返回的是行数
    @Insert({
            "insert into login_ticket(user_id,ticket,status,expired) ",
            "values(#{userId},#{ticket},#{status},#{expired}) "
    })
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertLoginTicket(LoginTicket loginTicket);
    //    查询方法，整个表是围绕ticket进行的
//    唯一的标识，利用这个标识进行查表
    @Select({
            "select id,user_id,ticket,status,expired ",
            "from login_ticket where ticket =#{ticket} "
    })
    LoginTicket selectByTicket(String ticket);
//    修改凭证的状态，如果是退出，则进行更改
    @Update({
//            动态的sql
//            "<script>",
//            "update login_ticket set status =#{status} where ticket=#{ticket} ",
//            "if test=\"ticket!=null\"> ",
//            "and 1=1 ",
//            "</if>",
//            "</script>"
            "<script>",
            "update login_ticket set status=#{status} where ticket=#{ticket} ",
            "<if test=\"ticket!=null\" >",
            "and 1=1",
            "</if>",
            "</script>"
    })
    int updateStatus(String ticket,int status);
}
