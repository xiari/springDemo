package com.dubbo.rpc;

import com.dubbo.service.CustomerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 采用RPC方式提供服务
 */
public class Provider {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/applicationProvider.xml"});
        context.start();
        CustomerService demoService1 = (CustomerService) context.getBean("customerServerImpl"); // get remote service proxy
        CustomerService demoService2 = (CustomerService) context.getBean("customerServerImpl"); // get remote service proxy

        CustomerService demoService3 = (CustomerService) context.getBean("demoService"); // get remote service proxy
        CustomerService demoService4 = (CustomerService) context.getBean("demoService"); // get remote service proxy

        System.out.println(demoService1.toString() +  demoService2  + demoService3 + demoService4);

        // press any key to exit
        System.in.read();
    }
}
