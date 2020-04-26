
//给定一个二叉树，返回它的中序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P94BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
        String s = "4(2(3)(1))(6(5))";
        TreeNode treeNode = str2tree(s);

        System.out.println(solution.inorderTraversal(treeNode));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    class Solution {
        /**
         * 方法一: 递归实现, 左子树不为空就继续遍历左子树、否则添加节点, 右子树不问空就遍历
         * @param root
         * @return
         */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        helper(root, res);
//        return res;
//    }
//
//    public void helper(TreeNode root, List<Integer> res) {
//       if (root != null) {
//           // 遍历左子树
//           if (root.left != null) helper(root.left, res);
//           res.add(root.val);
//           // 遍历右子树
//           if (root.right != null) helper(root.right, res);
//       }
//    }

        /**
         * 方法二: 用桟实现
         * 时间复杂度和空间复杂度都是 O(n)
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }
            return res;


//        List<Integer> res = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode curr = root;
//        while (curr != null || !stack.isEmpty()) {
//            while (curr != null) {
//                stack.push(curr);
//                curr = curr.left;
//            }
//            curr = stack.pop();
//            res.add(curr.val);
//            curr = curr.right;
//        }
//        return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static TreeNode str2tree(String s) {
        /**
         * 遍历字符串、若遇到了数字、则创建节点
         * 若stack不为空、则获取顶层元素,
         *              若顶层元素的左子树为null, 则当前元素为顶层元素的左子树
         *              若顶层元素左子树不为null, 将当前节点连接在右子树
         * 若遇到 ")" 弹出栈顶元素, 直到字符串遍历完成
         */
        if (s == null || s.length() == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        char curChar; // 当前遍历的字符
        for (int i = 0;  i < s.length(); i++ ) {
            curChar = s.charAt(i);
            // 若遇到')'则弹出栈顶元素, 当前子树创建完成
            if (curChar == ')') stack.pop();
                // 若遇到的是数字则创建节点
            else if (curChar >= '0' && curChar <= '9' || curChar == '-') {
                int start = i;
                // 循环查找一个完整的数字
                while (i < s.length() && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9') {
                    i++;
                }
                TreeNode root = new TreeNode(Integer.parseInt(s.substring(start, i+1)));
                // 获取父节点
                if (!stack.isEmpty()) {
                    // 获取当前栈顶元素
                    TreeNode parent = stack.peek();
                    // 若当前栈顶元素的左子树为空, 将当前节点作为栈顶元素的左子树
                    if (parent.left == null) parent.left = root;
                        // 否则作为栈顶元素的右子树
                    else parent.right = root;
                }
                stack.push(root);
            }
        }
        if (stack.isEmpty()) return null;
        return stack.peek();
    }
}