package com.demo.mvc;

import com.demo.mvc.springFrameStudy.HelloBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by XYY78 on 2016/10/27.
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath*:spring/applicationContext-test.xml")
public class HelloTest {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext-test.xml");

        HelloBean helloBean = (HelloBean)context.getBean("helloBean");

        System.out.print(">>>>>>> 打印结果 <<<<<<<< \n");

        System.out.print(helloBean.getName());

    }
}