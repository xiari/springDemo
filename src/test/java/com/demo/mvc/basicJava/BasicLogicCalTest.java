package com.demo.mvc.basicJava;


/**
 * java的传参都是传值，不管是原始对象还是引用对象
 * java 中通过new 返回一个对象引用
 */
public class BasicLogicCalTest {


    public static void main(String argv[]) throws InterruptedException {
        System.out.println( 12 & (16-1) );
        System.out.println( 12 % 16 );
    }
}
