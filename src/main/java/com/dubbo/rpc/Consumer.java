package com.dubbo.rpc;

import com.dubbo.service.CustomerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

import static java.lang.Thread.sleep;

/**
 * 采用RPC方式提供调用服务
 */
public class Consumer {

    public static void main(String[] args) throws IOException, InterruptedException {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/applicationConsumer.xml"});
        context.start();

        CustomerService demoService = (CustomerService) context.getBean("customerServerImpl"); // get remote service proxy

        for(int i = 0 ; i < 200 ; i++){
            sleep(3*1000);
            System.out.println(demoService.sayHello("zhanggang "));
        }
        // press any key to exit
        System.in.read();
    }
}
