package com.demo.mvc.basicJava.proxy.TestApp;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/3/9
 * Time: 11:16
 * To change this template use File | Settings | File Templates.
 */

public class IHelloImpl implements IHello {
    @Override
    public void hello(String name) {
        System.out.print("hello " + name + "\n");
    }
}
