package com.demo.mvc.basicJava;

/**
 * "+"在string中被重载，当+ 与对象连接时，会调用对象的toString()方法，如果在line12行使用this，而非super.toString()会导致
 * 意想不到的递归，导致栈溢出
 *
 */
public class InfiniteRecursion {

    public String toString() {
        return " InfiniteRecursion address: " + super.toString() + "\n";
    }
    public static void main(String[] args) {
//        List<InfiniteRecursion> v =
//                new ArrayList<>();
//        for(int i = 0; i < 10; i++)
//            v.add(new InfiniteRecursion());
//        System.out.println(v);
        System.out.print(" pls input ur name : +\n");
    }
}
