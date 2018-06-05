package com.demo.mvc.springFrameStudy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/3
 * Time: 17:30
 * Desc:
 * To change this template use File | Settings | File Templates.
 */

@Service("helloBean")
public class HelloBean implements InitializingBean,DisposableBean{

    public HelloBean(){
        System.out.print(">>>>>>> 执行HelloBean构造函数 <<<<<<<<<" + "\n");
    }

//    @PostConstruct
    public void init(){
        System.out.print(">>>>>>> 执行initMethod方法 <<<<<<<<<" + "\n");
    }
//    @PreDestroy
    public void destory(){
        System.out.print(">>>>>>> 执行destory方法 <<<<<<<<<" + "\n");
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<< InitializingBean.afterPropertiesSet..>>>>>>>>>>>>>>>>>>" + "\n");
    }

    @Override
    public void destroy() throws Exception {
        System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<< DisposableBean.destroy..>>>>>>>>>>>>>>>>>>" + "\n");

    }
}
