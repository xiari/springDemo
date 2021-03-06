package com.demo.mvc.basicJava.proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/** 代理实现方式一般有3种方式
 * 方式1：静态方式
 * 方式2：jdk基于接口的动态代理
 * 方式3：cglib
 */
public class CglibProxyFactory implements MethodInterceptor {

    private Object target; // 维护一个目标对象

    public CglibProxyFactory(Object o) {
        this.target = o;
    }

    public Object getProxyInstance(){
        // 1. 工具类
        Enhancer enhancer = new Enhancer();
        // 2. 设置父类
        enhancer.setSuperclass(target.getClass());
        // 3. 设置回调函数
        enhancer.setCallback(this);
        // 4. 创建代理类
        return enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事务...");
        //执行目标对象的方法
        Object returnValue = method.invoke(target, args);
        System.out.println("提交事务...");
        return returnValue;
    }
}
