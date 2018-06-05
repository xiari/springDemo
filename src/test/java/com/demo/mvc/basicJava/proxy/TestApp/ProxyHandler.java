package com.demo.mvc.basicJava.proxy.TestApp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/3/9
 * Time: 10:37
 * To change this template use File | Settings | File Templates.
 */

public class ProxyHandler implements InvocationHandler {

    private Object target;

    public ProxyHandler(Object o){
        this.target = o;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.print(method.getName()+ ":"+ method.getDeclaringClass().getName() +"\n");

        return method.invoke(target, args);
    }
}
