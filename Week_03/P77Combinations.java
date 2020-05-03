package leetcode.editor.cn;

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: c
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P77Combinations {
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
        // todo
        System.out.println(solution.combine(4, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> combine(int n, int k) {

            /**
             * 方法: 回溯
             * 关键:
             * 1. 画图、清晰的展现递归结构, 按顺序取就无需使用used数组判断是否已经获取过
             * 2. 在树的第k层结算, 因此pre的长度是无需关注的
             * 3. 有一些分支可能无需关注, 最后优化
             */
            // 特殊判断
            if ( k <= 0 || n < k) {
                return res;
            }
            // 从1开始是题目的设定
            findCombinations(n, k, 1, new Stack<>());
            return res;
        }

        private void findCombinations(int n, int k, int begin, Stack<Integer> pre) {
            if (pre.size() == k) {
                res.add(new ArrayList<>(pre)); // 够数了, 添加到结果集
                return;
            }

            // 关键在于分析出i的上界
//            for (int i = begin; i <= n; i++) {
//                pre.add(i);
//                findCombinations(n, k, i+1, pre);
//                pre.pop();
//            }
            /**
             * 优化剪枝的过程其实就是发现不可能条件的过程
             * 比如, 若我们至少需要2个元素, 那其实只剩下一个元素肯定是不可能满足的
             */
            for (int i = begin; i <= n - (k - pre.size()) + 1; i++) {
                pre.push(i);
                findCombinations(n, k, i+1, pre);
                pre.pop();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}