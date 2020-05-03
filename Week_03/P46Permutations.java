package leetcode.editor.cn;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.List;

public class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // todo

        int[] nums = {1, 2, 3};
        System.out.println(solution.permute(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            int len = nums.length;
            // 使用一个动态数组保存所有可能的全排列
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) return res;

            boolean[] used = new boolean[len];
            List<Integer> path = new ArrayList<>();

            dfs(nums, len, 0, path, used, res);
            return res;
        }

        private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
            if (depth == len) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i<len; i++) {
                if (!used[i]) {
                    path.add(nums[i]);
                    used[i] = true;

                    dfs(nums, len, depth+1, path, used, res);
                    // 重置状态, 从深层节点回到浅层节点
                    used[i] = false;
                    path.remove(path.size() - 1);
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}