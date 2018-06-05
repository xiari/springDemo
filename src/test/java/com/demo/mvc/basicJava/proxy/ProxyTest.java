package com.demo.mvc.basicJava.proxy;


import com.demo.mvc.basicJava.proxy.TestApp.IHello;
import com.demo.mvc.basicJava.proxy.TestApp.IHelloImpl;
import com.dubbo.service.CustomerService;
import com.dubbo.service.CustomerServiceImpl;

/**java设计模式中三种使用方式
 */
public class ProxyTest {

    public static void main(String argv[]) throws InterruptedException {
        ProxyFactory proxyFactory = new ProxyFactory(new IHelloImpl());
//        CustomerService customerService = (CustomerService)proxyFactory.getNewInstance();
//        System.out.println(customerService.sayHello("zhangGang"));

        IHello iHello1 = (IHello)proxyFactory.getNewInstance();
        IHello iHello2 = (IHello)proxyFactory.getNewInstance();
        System.out.print(iHello1+ "\n");
        System.out.print(iHello2+ "\n");

        iHello1.hello("me ~~");

//        CglibProxyFactory cglibProxyFactory = new CglibProxyFactory(new CustomerServiceImpl());
//        CustomerService service = (CustomerService)cglibProxyFactory.getProxyInstance();
//        System.out.println(service.sayHello("xiaoming"));
    }
}
