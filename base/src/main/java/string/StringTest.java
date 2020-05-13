package string;

import com.sun.tools.javac.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created with H
 * Description:
 * Time: 2020/5/8
 */
public class StringTest {


    public static void main(String[] args) {
//        int i = lengthOfLongestSubstring("abcabefa");
        reverseWords("the sky is blue");
//        System.out.printf("i="+i);
    }




    /**
     * 定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    /**
     * 最长公共前缀
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }

    /**
     * 字符串单词反转
     * @param s
     */
    public static void reverseWords(String s) {
        String[] arr=s.split(" ");
        Stack<String> stack=new Stack();
        StringBuffer stringBuffer=new StringBuffer();
        for(String s1:arr){
            stack.push(s1);
        }

        while (!stack.empty()){
            String pop = stack.pop();
            stringBuffer.append(pop+" ");
        }

        System.out.printf("输出:"+stringBuffer.toString());
    }




}
