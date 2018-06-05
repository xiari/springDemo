package com.demo.mvc.basicJava;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * string是常量池中存储
 *
 */
public class StringTest {

    public static void main(String[] args){
//        Integer i = new Integer(4);
//        String s1 = new String(i.toString());
//        String s2 = s1.intern();
//        System.out.println("s1 == s1.intern() ? " + (s1 == s1.intern()));//true
//        System.out.println(s1 == s2);//true
        counter();
    }
    private static void counter(){
        String targetStr = "zhang gang shuo ni shi 中国 de~";
        String[] arr = targetStr.split(" ");
        long start =   System.currentTimeMillis();
        for (int j = 0; j <  10000000; j++) {
            Map<String,Integer> counterMap00 = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                if(counterMap00.containsKey(arr[i])){ // 1. 用contains
                    counterMap00.put(arr[i],counterMap00.get(arr[i]) + 1);
                }else {
                    counterMap00.put(arr[i], +1);
                }
            }
        }
        long end0 =   System.currentTimeMillis();
        System.out.print(end0 - start + "  用contains\n");
        for (int j = 0; j <  10000000; j++) {
            Map<String,Integer> counterMap00 = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                if(counterMap00.get(arr[i]) != null ){ // 2. 用get替换contains
                    counterMap00.put(arr[i],counterMap00.get(arr[i]) + 1);
                }else {
                    counterMap00.put(arr[i], +1);
                }
            }

        }
        long end1 =   System.currentTimeMillis();
        System.out.print(end1 - end0 + "  用get替换contains \n");
        for (int j = 0; j <  10000000; j++) {
            Map<String,MutableInteger01> counterMap11 = new HashMap<>();
            for (int i = 0; i < arr.length; i++) { // 3. 采用get + 变量值（避免常量值大量创建)
                if(counterMap11.get(arr[i]) != null){
                    MutableInteger01 oldVal = counterMap11.get(arr[i]);
                    oldVal.setVal(oldVal.getVal() + 1);
                }else {
                    counterMap11.put(arr[i], new MutableInteger01(1));
                }
            }
        }
        long end2 =   System.currentTimeMillis();
        System.out.print(end2 - end1 + " 采用get + 变量值（避免常量值大量创建) \n");
        for (int j = 0; j <  10000000; j++) {
            Map<String,AtomicInteger> counterMap100 = new HashMap<>();
            for (int i = 0; i < arr.length; i++) { // 4. 采用getKey + 原子变量
                AtomicInteger val = counterMap100.get(arr[i]);
                if(val != null){
                    val.incrementAndGet();
                }else {
                    counterMap100.put(arr[i],new AtomicInteger(1));
                }
            }
        }
        long end3 =   System.currentTimeMillis();
        System.out.print(end3 - end2 + "  采用getKey + 原子变量 \n");
        for (int j = 0; j <  10000000; j++) {
            Map<String,int[]> counterMap11 = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {  // 5.使用int[] 作为计数器
                int[] val = counterMap11.get(arr[i]);
                if(val != null){
                    val[0]++;
                }else {
                    counterMap11.put(arr[i],new int[]{1});
                }
            }
        }
        long end4 =   System.currentTimeMillis();
        System.out.print( end4 - end3 + " 使用int[] 作为计数器 \n");
        for (int j = 0; j <  10000000; j++) {
            Map<String,MutableInteger01> counterMap11 = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {  // 5.使用AtomicInteger 作为计数器
                MutableInteger01 init = new MutableInteger01(1);
                MutableInteger01 old = counterMap11.put(arr[i],init);
                if(old != null){
                    old.setVal(old.getVal()+1);
                }else {
                    counterMap11.put(arr[i],init);
                }
            }
        }
        long end5 =   System.currentTimeMillis();
        System.out.print(end5 - end4 + " 使用put + MutableInteger01 作为计数器 \n");

        for (int j = 0; j <  10000000; j++) {
            Map<String,MutableInteger01> counterMap = new HashMap<>();
            for (int i = 0; i < arr.length; i++) { // 4. contains + 变量类型
                MutableInteger01 val = counterMap.get(arr[i]);
                if(val != null){
                    val.setVal(val.getVal() + 1);
                }else {
                    counterMap.put(arr[i],new MutableInteger01(1)); //
                }
            }
        }
        long end6 =   System.currentTimeMillis();
        System.out.print(end6 - end5 + "  使用contains + 变量类型 \n");
    }


    private static class MutableInteger01 {
        private int val;
        public MutableInteger01(int val){
            this.val= val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }

    /**
     *
     * 执行结果如下，与预期不太一样，大致思路是：避免常量池大量创建，减少从map中get次数。
     2902  用contains
     4889  用get替换contains
     5245 采用get + 变量值（避免常量值大量创建)
     8052  采用getKey + 原子变量
     5297 使用int[] 作为计数器
     7454 使用put + AtomicInteger 作为计数器

     */
}
