package org.example.leetcode.tree;

public class P124MaxPathSum {

    class TreeNode {
        int val;
        TreeNode left, right;
    }
    static class Solution {
        int max = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            if (root == null) return 0;
            dfs(root);
            return max;
        }

        /**
         * 返回经过root的单边分支最大和,
         * 即Math.max(root, root+left, root+right)
         */
        public int dfs(TreeNode root) {
            if (root == null) return 0;

            int leftMax = Math.max(0, dfs(root.left));
            int rightMax = Math.max(0, dfs(root.right));
            max = Math.max(max, root.val + leftMax + rightMax);

            return root.val + Math.max(leftMax, rightMax);
        }
    }
}
