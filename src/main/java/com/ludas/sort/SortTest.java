package com.ludas.sort;

import java.util.Arrays;

public class SortTest {

    public static void main(String[] args) {
        sort();

    }


    public static void sort() {

        int[] array = {4, 2, 5, 3, 6, 0};
        /**
         * 选择排序
         */
        int length=array.length;
        for(int i=0;i<length;i++){
            int value=array[i];
            for(int j=i;j<length;j++){
                 //找最小的位置
                if(value>array[j]){

                }
            }


        }

        System.out.println(Arrays.toString(array));

    }
}
