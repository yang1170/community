package com.newcoder.community.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
//@Component
//@Aspect
public class AlphaAspect {
    @Pointcut("execution(* com.newcoder.community.service.*.*(..))")

    public void pointcut(){

    }
    @Before("pointcut()")
    public void before(){
        System.out.println("before");
    }
//    定义通知
    @After("pointcut()")
    public void after(){
    System.out.println("after");
}
    @AfterReturning("pointcut()")
    public void afterReturn(){
        System.out.println("afterReturn");
    }
}
