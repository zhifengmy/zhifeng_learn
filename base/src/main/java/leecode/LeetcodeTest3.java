package leecode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author LuDas
 * @Description:给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * @date 2019/4/10 15:31
 */
public class LeetcodeTest3 {

    /**
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */


    public static void main(String[] args) {
       int a=1;
        do {
            System.out.println(1111111);
        } while (a!=1);
    }

    /**
     * 暴力循环
     */
    public static void method1(){

    }

    /**
     * 如果子字符串中字符是唯一的返回true，否者返回false
     * @param str
     * @param start
     * @param end
     * @return
     */
    public static boolean allUnique(String str,int start,int end){

        Set<Character> set=new HashSet<>();
        for(int i=start;i<end;i++){
            Character c = str.charAt(start);
            if(!set.contains(c)){
                set.add(c);
                return  true;
            }
        }
        return false;
    }
}
