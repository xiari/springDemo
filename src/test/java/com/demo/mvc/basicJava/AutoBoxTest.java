package com.demo.mvc.basicJava;


/**
 * java的传参都是传值，不管是原始对象还是引用对象
 * java 中通过new 返回一个对象引用
 */
public class AutoBoxTest {


    public static void main(String argv[]) throws InterruptedException {
//        Integer i = 1;
//        Integer j = 2;
//
//        Integer k = i + j ; // 先拆箱做运算，然后再装箱将对象引用返回
//        Integer l = 3 ;
//
//
//        System.out.print(i == j );
//        System.out.print("\n");
//        System.out.print( k == l);
//        System.out.print("\n");
//
//        Integer i100 = 100;
//
//        Integer i200 = 200;
//
//        Integer i300  = i100 + i200;
//
//        Integer j300 = 300;
//        System.out.print("\n");
//        System.out.print(i300 == j300);
//        System.out.print("\n");

        Float f = 1.12f;
        Float g = 1.12f;

        Float m = f + g ; // 先调用floadValue(),拆箱，然后再装箱返回引用

        Float n = 2.24f;
        System.out.print(f == g);
        System.out.print("\n");
        System.out.print(1.12f == 1.12f);
        System.out.print("\n");
        System.out.print(f.hashCode() + ":" + g.hashCode());
        System.out.print("\n");


        System.out.print(m == n);
        System.out.print("\n");


    }
}
