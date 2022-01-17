package com.newcoder.community.controller.iterceptor;

import com.newcoder.community.entity.LoginTicket;
import com.newcoder.community.entity.User;
import com.newcoder.community.service.UserService;

import com.newcoder.community.util.CookieUtil;
import com.newcoder.community.util.HostHolder;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class LoginTicketInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;
    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从cookie中获取凭证
        String ticket = CookieUtil.getValue(request, "ticket");
        if (ticket != null) {
            //查询login——ticket表返回LoginTicket
            LoginTicket loginTicket = userService.findLoginTicket(ticket);
            if (loginTicket != null && loginTicket.getStatus() == 0 && loginTicket.getExpired().after(new Date())) {
                //根据凭证查询用户
                User user = userService.findUserById(loginTicket.getUserId());
                //在本次请求中持有用户 利用threadLocal hostHolder是单例的

                hostHolder.setUser(user);

                //构建用户认证的结果，并存入SecurityContext，以便于Security进行授权
//                Authentication authentication=new UsernamePasswordAuthenticationToken(
//                        user,user.getPassword(),userService.getAuthorities(user.getId())
//                );
//                SecurityContextHolder.setContext(new SecurityContextImpl(authentication));



            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        User user = hostHolder.getUser();
        if (user != null && modelAndView != null) {
            modelAndView.addObject("loginUser", user);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //请求结束
        hostHolder.clear();
//        SecurityContextHolder.clearContext();
    }
}
