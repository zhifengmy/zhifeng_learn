package com.ludas.sort;


import java.util.Arrays;

/**
 * @author KyLin
 * @Description:排序相关
 * @date 2018/12/20 10:40
 */
public class Sort {


    public static void main(String[] args) {
        bubbleSort();
    }

    /**
     * @Description:冒泡排序实现
     * @author KyLin
     * @date 2018/12/20 10:50
     */
    public static void bubbleSort() {

        int[] array = {4, 2, 5, 3, 6, 0};
        for (int i = 0; i < array.length; i++) {
            //没有元素互换位置的时候就可以跳出循环
            boolean flag = false;
            for (int j = i+1; j < array.length; j++) {
                if (array[i]>array[j]) {
                    int temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * @Description:插入排序
     * @author KyLin
     * @date 2018/12/20 16:28
     */
    public static void insertSort() {

        int[] array = {4, 2, 5, 3, 6, 0};
        int n = array.length;
        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; ++i) {
            //带插入元素
            int value = array[i];
            //已经排序位置
            int j = i - 1;
            // 从数组尾部查找插入的位置
            for (; j >= 0; --j) {
                if (array[j] > value) {
                    // 数据移动
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            // 插入数据
            array[j + 1] = value;
        }

        System.out.println(Arrays.toString(array));
    }

    /**
     * @Description:选择排序
     * @author KyLin
     * @date 2018/12/20 17:27
     */
    public static void selectSort() {
        int[] arr = {4, 2, 5, 3, 6, 0};
        //选择排序的优化
        // 做第i趟排序
        for (int i = 0; i < arr.length - 1; i++) {
            int k = i;
            // 选最小的记录
            for (int j = k + 1; j < arr.length; j++) {
                if (arr[j] < arr[k]) {
                    //记下目前找到的最小值所在的位置
                    k = j;
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            //交换a[i]和a[k]
            if (i != k) {
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    /**
    * @Description:归并排序
    * @author KyLin
    * @date 2018/12/21 14:14
    */
    public static void spliMergeSort(){
        int[] arr = {4, 2, 5, 3, 6, 0};





        System.out.println(Arrays.toString(arr));
    }



}
