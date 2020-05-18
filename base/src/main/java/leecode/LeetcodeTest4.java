package leecode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class LeetcodeTest4 {


    public static void main(String[] args) {
        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(arr);
        System.out.printf("i="+i);

    }



    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i- 1] + nums[i], nums[i]);
            if (dp[i]>max) {
                max = dp[i];
            }
        }
        return max;
    }


}
