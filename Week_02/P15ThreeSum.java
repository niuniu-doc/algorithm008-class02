package leetcode.editor.cn;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例：
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//
// Related Topics 数组 双指针


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        // todo
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums1 = new int[]{0, 0, 0};
        int[] nums3 = new int[]{-2, -2, 4};
        int[] nums2 = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
//        System.out.println(solution.threeSum(nums));
//        System.out.println(solution.threeSum(nums1));
        System.out.println(solution.threeSum(nums2));
//        System.out.println(solution.threeSum(nums3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            /**
             * 1. 特殊逻辑: 若数组为 null, 或者 nums.length < 3, 不满足, return []
             * 2. 对原数组排序
             * 3. 遍历数组, 令左指针 L = i + 1, 右指针 R = n-1, 若 L < R, 执行循环
             *    1) 若 nums[i] + nums[L] + nums[R] == 0, 满足条件,
             *       判断L, R是否和下一位置重复, 去除重复解, 并继续移动L, R寻找下一组解
             *    2) 若 和 > 0, 说明 R偏大, R左移
             *    3) 若 和 <0, 说明 L偏小, L右移
             */
            if (nums == null || nums.length < 3) return new ArrayList<>();
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            int L, R, len = nums.length, sum;
            for (int i = 0; i < len - 1; i++) {
                if (nums[i] > 0) return res; // 若 nums[i]>0, 无需继续求解, 排序后数据, min>0, 则sum必然>0
                if (i > 0 && nums[i] == nums[i-1]) continue; // 跳过重复值
                L = i + 1; R = len -1;
                while (L < R) {
                    sum = nums[i] + nums[L] + nums[R];
                    if (sum == 0) {
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.addAll(Arrays.asList(nums[i], nums[L], nums[R]));
                        res.add(tmp);
                        while(L < R && nums[L+1] == nums[L]) ++L;
                        while (L < R && nums[R-1] == nums[R]) --R;
                        ++L;
                        --R;
                    } else if (sum < 0) {
                        ++L;
                    } else {
                        // sum > 0, R 左移
                        --R;
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}