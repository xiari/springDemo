package com.demo.mvc.redis;


import com.demo.mvc.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import com.demo.mvc.utils.RedisClientUtils;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:spring/applicationContext.xml"})
public class RedisApp {

    @Resource
    private RedisClientUtils redisClientUtils;

    @Test
    public void test(){
        redisClientUtils.add("111","121212");
        System.out.println(redisClientUtils.get("849d90cc-daa6-45db-9e58-6e029d54dd46"));
        System.out.print("end =========");

        List<String> list = new ArrayList<>();
        list.add("va1");
        list.add("va2");
        list.add("va3");
        list.add("va4");
        redisClientUtils.lAddList("list", list);
        System.out.println(redisClientUtils.getList("list"));
        System.out.print("end1 =========");

        List<Person> list1 = new ArrayList<>();
        list1.add(new Person("zahngagn1"));
        list1.add(new Person("zahngagn2"));
        list1.add(new Person("zahngagn3"));
        list1.add(new Person("zahngagn4"));
        redisClientUtils.lAddList("list1", list1);
        System.out.println(redisClientUtils.getList("list1"));
        System.out.print("end2 =========");
    }
}
