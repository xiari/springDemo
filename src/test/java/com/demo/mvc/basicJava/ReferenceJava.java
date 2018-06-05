package com.demo.mvc.basicJava;


/**
 * java的传参都是传值，不管是原始对象还是引用对象
 * java 中通过new 返回一个对象引用
 */
public class ReferenceJava {
    public int i, j;

    public void test_m(ReferenceJava a) {
        ReferenceJava b = new ReferenceJava();
        b.i = 1;
        b.j = 2;
        a = b;
        System.out.println("a.i   =   " + a.i + "   a.j=   " + a.j); //5,6

    }

    public void test_m1(ReferenceJava a) {
        a.i = 1;
        a.j = 2;
    }

    public static void main(String argv[]) {

        //
        ReferenceJava t = new ReferenceJava();
        t.i = 5;
        t.j = 6;
        System.out.println("t.i   =   " + t.i + "   t.j=   " + t.j); //5,6
        t.test_m(t);
        System.out.println("t.i   =   " + t.i + "   t.j=   " + t.j); //5,6, a和t都指向了一个对象，而在test_m中s又指向了另一个对象，所以对象t不变！！！

        t.test_m1(t);

        System.out.println("t.i   =   " + t.i + "   t.j=   " + t.j); //1,2

    }
}
