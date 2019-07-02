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
        int i = method1();
        System.out.printf("最长子串:"+i);
    }

    /**
     * 暴力循环
     * 时间复杂度O(n^3)
     */
    public static int method1(){
        String str="abcabcbb";
        int n=str.length();
        int ans = 0;
        //两层循环找出该字符串中所有的的子串
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                String aa=str.substring(i,j);
                if (allUnique(str, i, j))
                    ans = Math.max(ans, j - i);
            }
        }
        return ans;
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
            Character c = str.charAt(i);
            if(set.contains(c)) return  false;
            set.add(c);
        }
        return true;
    }


    /**
     * 滑动窗口(使用HashMap)
     */
    public static int method2(){
        String str="abcabcbb";





        return 0;
    }



}
