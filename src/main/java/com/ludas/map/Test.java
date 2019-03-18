package com.ludas.map;

public class Test {

    /**
     * 面试题：为啥HashMap的长度是2^n
     * @param args
     */
    public static void main(String[] args) {

        /**
         * map中计算 key在数组中的index位置
         * 算法：index=hash&(length-1) == hash%length
         *
         * 解答：只有length是2^n的时候hash&(length-1) == hash%length
         */

        int length = 16;
        int hash = 123121;

        int i = hash % length;
        int j = hash & (length - 1);
        System.out.println("%=" + i+" &=" + j);

    }
}
