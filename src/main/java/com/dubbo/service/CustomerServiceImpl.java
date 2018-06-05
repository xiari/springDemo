package com.dubbo.service;

/**
 * Created by XYY78 on 2016/11/22.
 */
public class CustomerServiceImpl implements CustomerService {

    public String sayHello(String name) {

        return "hello " + name ;

    }
}
