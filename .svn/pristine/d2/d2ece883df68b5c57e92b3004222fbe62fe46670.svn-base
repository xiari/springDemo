package com.demo.mvc.utils;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAspect {

    // 环绕
    public Object monitor(ProceedingJoinPoint  pjp) throws Throwable {
        Object object = null;
        System.out.println("advice around >>>>>>>>>>>>>>>>>>>>>>>>>>>>before<<<<<<<<<<<<<<<<<<<<<<");
        object = pjp.proceed();
        System.out.println("advice around >>>>>>>>>>>>>>>>>>>>>>>>>>>>after<<<<<<<<<<<<<<<<<<<<<<");
        return object;
    }

    // before
    public void before(JoinPoint joinPoint) throws Throwable{
        System.out.println("advice before >>>>>>>>>>>>>>>>>>>>>>>>>>>>before<<<<<<<<<<<<<<<<<<<<<< ");
    }

    // after
    public void after(JoinPoint joinPoint) throws Throwable{
        System.out.println("advice after >>>>>>>>>>>>>>>>>>>>>>>>>>>>after<<<<<<<<<<<<<<<<<<<<<< ");
    }

}
