package com.dubbo.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by XYY78 on 2016/11/22.
 */
public class CustomerServiceFactoryBean implements FactoryBean<CustomerService> , InitializingBean, DisposableBean {

    private CustomerService customerService;
    @Override
    public CustomerService getObject() throws Exception {
        return new CustomerServiceImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
