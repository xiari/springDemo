package com.demo.mvc.basicJava.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** 代理实现方式一般有3中方式
 * 方式1：静态方式
 * 方式2：jdk基于接口的动态代理
 * 方式3：cglib
 */
public class ProxyFactory {

    private Object target; // 维护一个目标对象

    public ProxyFactory(Object o) {
        this.target = o;
    }

    // jdk方式返回代理对象
    public Object getNewInstance() {
       return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 获取目标对象的类加载器
                target.getClass().getInterfaces(), // 获取目标对象（实现类）的接口
                new InvocationHandler() {       // 代理对象行为执行器，可显性声明或匿名声明（其实可以看做供用户调用的一个回调方法）
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开始事务 .... ");
                        System.out.println("执行事务 .... ");
                        Object result = method.invoke(target, args);
                        System.out.println("结束事务 .... ");
                        return result;
                    }
                });
    }

}
