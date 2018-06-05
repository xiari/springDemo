package com.demo.mvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:spring/applicationContext.xml"})
public class App {

    @Resource
    @Qualifier("redisTemplate")
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void test(){
        if(redisTemplate != null ) {
            System.out.print("-=========================");
        }
    }
}
