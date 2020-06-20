package org.example.leetcode.string;

import java.util.Arrays;

public class P300lengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(new Solution().lengthOfLIS(nums));
    }
    static public class Solution {
        public int lengthOfLIS(int[] nums) {
            
            int len = nums.length;
            if (len < 2) return len;

            int[] dp = new int[len];
            Arrays.fill(dp, 1);

            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            int res = 0;
            for (int i = 0; i < len; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }

}
