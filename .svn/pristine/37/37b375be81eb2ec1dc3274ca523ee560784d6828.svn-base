package com.demo.mvc.algorithm;

import com.demo.mvc.utils.JsonUtil;

/**
 * 字符串匹配算法差别在于回溯位置的算法不一致：
 * kmp通过记录最大相同前缀后缀字符串来确定回溯位置，通过修改next索引k值来处理
 * 暴力方式回溯到匹配字符串的下一个位置
 */
public class StrMatch {

    public static void main(String[] args){

        String srcStr = "agabcefabcfgagabcdaabcdamadbc";
        String pStr = "agabcda";
        System.out.println(stringMatcher(srcStr, pStr));

        int[] next = new int["agabcda".length()];
        makeNext("agabcda",next);
        System.out.println(JsonUtil.toJsonString(next));
        System.out.println(kmp(srcStr,pStr));

    }

    /**
     * KMP查找字符串位置
     * @param srcStr
     * @param pStr
     * @return
     */
    private static int kmp(String srcStr , String pStr){

        int sLen = srcStr.length();
        int pLen = pStr.length();
        int[] next = new int[srcStr.length()];
        makeNext(pStr, next);
        int k = 0 ;
        for(int i = 0 ; i < sLen; i++){
            while( k > 0 && srcStr.charAt(i) != pStr.charAt(k)){
                k = next[k-1];
            }
            if(srcStr.charAt(i) == pStr.charAt(k)){
                k++;
            }
            if(k == pLen){
                return i - pLen + 1;
            }
        }
        return -1;
    }

    /**
     * 字符串暴力匹配
     * @param srcStr
     * @param pStr
     * @return
     */
    private static int stringMatcher(String srcStr , String pStr) {

        int sLen = srcStr.length();
        int pLen = pStr.length();

        int i = 0 ;
        int j = 0 ;
        while( i < sLen && j < pLen){
            if(srcStr.charAt(i) == pStr.charAt(j)){
                i++;
                j++;
            }else {
                i = i - j + 1;
                j = 0;
            }
            if (j == pLen){
                return i - j  ; // 匹配位置点
            }
        }
        return  -1 ;
    }

    /**
     * 模式字符串中字符最大前后缀长度计算
     * @param pStr
     * @param next
     */

    public static void makeNext(String pStr, int[] next){

        int pLen = pStr.length();

        int q, k ; // p为模式字符串索引， k为最大前后缀长度
        next[0] = 0 ;
        for( q = 1 , k = 0 ; q < pLen ; ++q){ // 从第一个字符开始，第一个字符的最大相同前后缀长度为0
            while( k > 0 && pStr.charAt(q) != pStr.charAt(k)){ // 当最大前后缀长度为k,模式字符串索引为p时，求出pStr[0-q]的长度
                k = next[k-1];
            }
            if(pStr.charAt(q) ==  pStr.charAt(k)){
                k++;
            }
            next[q] = k;
        }
    }

    // 优化的kmp算法->BM算法->Sunday算法 未完待续，有点晕~~
}
