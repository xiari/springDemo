package com.demo.mvc.basicJava;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Thread.sleep;

public class CollectionTest {
    static HashMap<String, String> conMap = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
//        HashMap<String, String> linkedMap = new LinkedHashMap<>();
       Thread t1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    conMap.put(i+ "ttt", "value1");
                }
            }
        },"thread1");
       t1.start();

       Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    conMap.put(i+ "ttt", "value2");
                }
            }
        }, "thread2");
        t2.start();

       sleep(1000);
        for (Map.Entry<String, String> entry : conMap.entrySet()
             ) {
            System.out.println(entry.getKey()+ "_" +entry.getValue());
        }
    }
}
