package com.demo.mvc.basicJava.proxy.TestApp;


import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/3/9
 * Time: 10:38
 * To change this template use File | Settings | File Templates.
 */

public class App {

    public static void main(String[] args) throws Exception {

        IHelloImpl iHelloImpl = new IHelloImpl();
        IHello iHello =(IHello) Proxy.newProxyInstance(
                IHelloImpl.class.getClassLoader(),
                IHelloImpl.class.getInterfaces() ,
                new ProxyHandler(iHelloImpl));
        System.out.print(iHello.getClass());
        iHello.hello("zhangGang");
        iHello.toString();
        iHello.hashCode();
    }
}
