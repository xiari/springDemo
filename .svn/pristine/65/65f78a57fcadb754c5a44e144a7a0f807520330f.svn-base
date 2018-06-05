package com.demo.mvc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/3
 * Time: 17:30
 * Desc:
 * To change this template use File | Settings | File Templates.
 */

@Component
public class HelloBeanPostProcessor implements BeanPostProcessor {

    public HelloBeanPostProcessor() {
        super();
        System.out.println(">>>>>>>执行 BeanPostProcessor实现类构造器！！");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(">>>>>>>执行 postProcessBeforeInitialization ");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(">>>>>>>执行  postProcessAfterInitialization " );
        return bean;
    }
}
