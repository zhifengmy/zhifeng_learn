package com.ludas.sort;

import java.util.Arrays;

public class SortTest {

    public static void main(String[] args) {
        sort();

    }


    public static void sort() {

        int[] array = {4, 2, 5, 3, 6, 0};
        /**
         * 插入排序 原地，稳定算法
         */
        int length=array.length;
        for(int i=0;i<length;i++){
            int value=array[i];
            for(int j=0;i<i;j++){
                if(value<array[j]){
                   //数据移动

                }else{

                }
            }
        }

        System.out.println(Arrays.toString(array));

    }
}
