package org.example.leetcode.string;

import java.util.Arrays;

public class P300lengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(new Solution().lengthOfLIS(nums));
        System.out.println(new Solution().lengthOfLIS2(nums));
    }
    static public class Solution {
        public int lengthOfLIS(int[] nums) {
            /**
             * 1. 将子序列的长度定义为状态, 即: dp[i]表示以nums[i]结尾的上升子序列的长度
             * 2. 定义状态转移方程
             *    遍历nums[i]时, 需要将i之前的数全部看一遍, 若严格比它之前的某个数大, 就可以接在后边, 成为一个子序列
             *    dp[i] = max(dp[j]+1)
             * 3. 初始化, 1个字符是自己的上升序列
             * 4. 输出 最大值是 max(dp[i])
             * 5. 状态压缩, 由于要回看之前的状态、所以无法压缩
             */
            int len = nums.length;
            if (len < 2) return len; // 只有一个元素

            int[] dp = new int[len]; // 存放状态数组
            Arrays.fill(dp, 1); // 初始化状态方程

            for (int i=1; i<len; i++) {
                for (int j=0; j<i; j++) {
                    if (nums[j] < nums[i]) { // j<i, 若nums[j]>nums[i], 不可组成子序列, 否则序列不是严格上升的
                        dp[i] = Math.max(dp[i], dp[j]+1);
                    }
                }
            }

            int res = 0;
            for (int i=0; i<len; i++) {
                res = Math.max(res, dp[i]); // 取最长子序列
            }
            return res;
        }

        public int lengthOfLIS2(int[] nums) {
            /**
             * 1. 定义状态数组 tail[i]代表长度为i+1的所有上升子序列的结尾最小值
             * 2.
             */
            int len = nums.length;
            if (len < 1) return len;

            // 定义tail数组, 存储长度为i+1的上升子序列的末尾最小值
            int[] tail = new int[len];
            tail[0] = nums[0]; // 第1个数, 以它结尾的数组只有它自己, min也是它自己
            int end = 0; // 存储tail的处理的最后一个元素索引

            for (int i=1; i<len; i++) {
                if (nums[i] > tail[end]) {
                    end++;
                    tail[end] = nums[i]; // 比实际有效的末尾元素大、直接添加在数组后边
                } else {
                    // 在tail数组中使用二分查找, 找到第一个大于nums[i]的元素、尝试让它更小
                    int left=0, right=end;
                    while (left<right) {
                        int mid = left+((right-left) >>> 1);
                        if (tail[mid] < nums[i]) {
                            left = mid + 1;
                        } else {
                            right = mid;
                        }
                    }
                    tail[left] = nums[i]; // 找到＞nums[i]的第一个元素
                }
                printArray(nums[i], tail);
            }
            end++;
            return end;
        }

        private void printArray(int num, int[] tail) {
            System.out.println("current: " + num);
            System.out.println("\t current tail arr: " );
            int len = tail.length;
            for (int i=0; i<len; i++) {
                if (tail[i] == 0) break;
                System.out.println(tail[i] + ",");
            }
            System.out.println();
        }
    }

}
