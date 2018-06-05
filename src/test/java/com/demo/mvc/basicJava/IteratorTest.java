package com.demo.mvc.basicJava;


import com.demo.mvc.model.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * java的传参都是传值，不管是原始对象还是引用对象
 * java 中通过new 返回一个对象引用
 */
public class IteratorTest {


    public static void main(String argv[]) throws InterruptedException {

        final List<Person> personList = new ArrayList<Person>();

        Person person1 = new Person("zhanggang1");
        Person person2 = new Person("zhanggang2");
        Person person3 = new Person("zhanggang3");
        Person person4 = new Person("zhanggang4");
        Person person5 = new Person("zhanggang5");
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);

        ListIterator<Person> listIterator = personList.listIterator();

        listIterator.add(new Person("AGGNG"));
        System.out.println(personList.size());

        // 循环删除list元素
        final Iterator<Person> iterator = personList.iterator();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (iterator.hasNext()){
                    iterator.next();
                    iterator.remove();
                }
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                personList.add(new Person("mingming"));
            }
        });
//        thread2.start();
        thread1.join();
//        thread2.join();
        System.out.println(personList.size());
    }
}
