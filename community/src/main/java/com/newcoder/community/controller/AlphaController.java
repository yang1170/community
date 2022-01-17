package com.newcoder.community.controller;


import com.newcoder.community.util.CommunityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

//
//    @RequestMapping("/hello")
//    @ResponseBody
//    public String sayHello() {
//        return "Hello Spring Boot";
//    }
//
//    @RequestMapping("/data")
//    @ResponseBody
//    public String getData() {
//        return alphaService.find();
//    }

    //获得请求对象和响应
    @RequestMapping("http")
    public void http(HttpServletRequest request, HttpServletResponse response) {
//        不依赖返回值
//        读取数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + ":" + value);

        }
        System.out.println(request.getParameter("code"));
//    response 返回响应数据
        response.setContentType("text/html;charset=utf-8");
        try (PrintWriter writer = response.getWriter();) {

            writer.write("<h1>牛客</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    get请求


    //    查询所有的学生，查询需要控制分页，当前是第几页，一页最多是多少
    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(
            @RequestParam(name = "current", required = false, defaultValue = "1") int current,
            @RequestParam(name = "limit", required = false, defaultValue = "10") int limit) {
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }

    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id) {
        System.out.println(id);
        return "a student";
    }

    //    Post请求
//    带有表单的网页
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name, String age) {
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    //响应html数据
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "张三");
        modelAndView.addObject("age", 30);
        modelAndView.setViewName("/demo/view");
        return modelAndView;
    }

    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model) {
        model.addAttribute("name", "北京大学");
        model.addAttribute("age", 80);

        return "/demo/view";
    }

    //    响应JSON数据
//    java对象-》json字符串-》js对象
    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getEmp() {
    Map<String,Object> emp = new HashMap<>();
    emp.put("name","张三");
    emp.put("age",33);
    emp.put("salary",8000.00);
    return emp;
    }
//    cookie相关的测试的逻辑
//    接收浏览器的请求，使用get进行
    @RequestMapping(value = "/cookie/set",method = RequestMethod.GET)
    @ResponseBody //返回响应的内容，
    public String setCookie(HttpServletResponse response){
//        存在response里面
//        创建cookie
        Cookie cookie = new Cookie("code", CommunityUtil.generateUUid());
//        作为一些设置，生效的时间范围，不能每次都需要发
        cookie.setPath("/community/alpha");
//        默认存在浏览器，一旦关闭就是无效了,可以进行设置，单位是秒
        cookie.setMaxAge(60*10);
        response.addCookie(cookie);
        return "set cookie";


    }
    @RequestMapping(value = "/cookie/get",method = RequestMethod.GET)
    @ResponseBody //返回响应的内容，
    public String getCookie(@CookieValue("code") String code){
        System.out.println(code);
//        可以带给模板
        return "get cookie";
    }
//    session示例演示
    @RequestMapping(value = "/session/set",method = RequestMethod.GET)
    @ResponseBody //返回响应的内容，
    public String SetSession(HttpSession session){
//        不需要我们自动创建，spring mvc可以自动的注入进来
//        cooike 存的是字符串，session可以存任何类型的数据和体量
        session.setAttribute("id",1);
        session.setAttribute("name","Test");

        return "set session";
    }
    @RequestMapping(value = "/session/get",method = RequestMethod.GET)
    @ResponseBody //返回响应的内容，
    public String getSession(HttpSession session){
        System.out.println(session.getAttribute("id"));
        System.out.println(session.getAttribute("name"));
        return "get session";
    }
    //ajax示例
    @RequestMapping(path = "/ajax",method = RequestMethod.POST)
    @ResponseBody
    public String testAjax(String name,int age){
        System.out.println(name);
        System.out.println(age);
        return  CommunityUtil.getJSONString(0,"操作成功！");
    }

}

