package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class P22括号生成 {
    public class Solution {
        // 做减法
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if (n == 0) return res; // 特判
            dfs("", n, n, res); // 执行深度优先遍历，搜索可能的结果
            return res;
        }

        /**
         * curStr:当前递归得到的结果; left:左括号还有几个可以使用
         * right:右括号还有几个可以使用; res:结果集
         */
        private void dfs(String curStr, int left, int right, List<String> res) {
            // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
            // 在递归终止的时候，直接把它添加到结果集即可
            if (left == 0 && right == 0) {
                res.add(curStr);
                return;
            }

            // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝~~）
            if (left > right) return;
            if (left > 0) dfs(curStr + "(", left - 1, right, res);
            if (right > 0) dfs(curStr + ")", left, right - 1, res);
        }
    }

    public class Solution2 {
        // bfs
        class Node {
            private String res; //当前得到的字符串
            private int left; // 剩余左括号数量
            private int right; // 剩余右括号数量

            public Node(String str, int left, int right) {
                this.res = str;
                this.left = left;
                this.right = right;
            }
        }

        public List<String> generateParenthesis(int n) {
                List<String> res = new ArrayList<>();
                if (n == 0) return res;
                Queue<Node> queue = new LinkedList<>();
                queue.offer(new Node("", n, n));

                while (!queue.isEmpty()) {
                    Node curNode = queue.poll();
                    if (curNode.left == 0 && curNode.right == 0) {
                        res.add(curNode.res);
                    }
                    if (curNode.left > 0) {
                        queue.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
                    }
                    if (curNode.right > 0 && curNode.left < curNode.right) {
                        queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
                    }
                }
                return res;
            }
    }
}