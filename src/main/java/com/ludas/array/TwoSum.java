package com.ludas.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LuDas
 * @Description:求数组中两数之和坐标 example:[2,3,1,5,9] sum=4 position={1,2}
 * @date 2018/10/11 18:53
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] arr={3,1,5,9,2};
        int sum=5;
        String s = method3(arr, sum);
        System.out.println(s);

    }

    /**
    * @Description:暴力遍历，时间复杂度O(n^2)
    * @author LuDas
    * @date 2018/10/11 18:57
    */
    public static String method1(int[] arr,int sum){

        for(int i=0;i<arr.length;i++){
            int temp=arr[i];
            for (int y=i+1;y<arr.length;y++){
                if(temp+arr[y]==sum){
                    return i+","+y;
                }
            }
        }
        return null;
    }
    /**
     * @Description:两遍Hash表，时间复杂度O(n)
     * @author LuDas
     * @date 2018/10/11 18:57
     */
    public static String method2(int[] arr,int sum){
        Map<Integer,Integer> map=new HashMap();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        for(int i=0;i<arr.length;i++){
            int key = sum - arr[i];
            if(map.containsKey(key)){
               return i+","+map.get(key);
            }
        }
        return null;
    }

    /**
     * @Description:一遍Hash表，时间复杂度O(n)
     * @author LuDas
     * @date 2018/10/11 18:57
     */
    public static String method3(int[] arr,int sum){
        Map<Integer,Integer> map=new HashMap();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
            int key = sum - arr[i];
            if(map.containsKey(key)){
                return i+","+map.get(key);
            }
        }
        return null;
    }

}
