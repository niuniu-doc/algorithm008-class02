
//你需要从一个包括括号和整数的字符串构建一棵二叉树。
//
// 输入的字符串代表一棵二叉树。它包括整数和随后的0，1或2对括号。整数代表根的值，一对括号内表示同样结构的子树。
//
// 若存在左子结点，则从左子结点开始构建。
//
// 示例:
//
// 输入: "4(2(3)(1))(6(5))"
//输出: 返回代表下列二叉树的根节点:
//
//       4
//     /   \
//    2     6
//   / \   /
//  3   1 5
//
//
//
//
// 注意:
//
//
// 输入字符串中只包含 '(', ')', '-' 和 '0' ~ '9'
// 空树由 "" 而非"()"表示。
//
//
//
// Related Topics 树 字符串


import java.util.Stack;

/**
 * 从字符串构建二叉树
 */
public class P536ConstructBinaryTreeFromString {
    public static void main(String[] args) {
        Solution solution = new P536ConstructBinaryTreeFromString().new Solution();
        // todo
        String s = "4(2(3)(1))(6(5))";
        System.out.println(solution.str2tree(s));
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
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public TreeNode str2tree(String s) {
            /**
             * 遍历字符串、若遇到了数字、则创建节点
             * 若stack不为空、则获取顶层元素,
             *              若顶层元素的左子树为null, 则当前元素为顶层元素的左子树
             *              若顶层元素左子树不为null, 将当前节点连接在右子树
             * 若遇到 ")" 弹出栈顶元素, 直到字符串遍历完成
             */
            if (s == null || s.length() == 0) return null;
            Stack<TreeNode> stack = new Stack<>();
            char curChar;
            for (int i = 0; i < s.length(); i++) {
                curChar = s.charAt(i);
                if (curChar == ')') stack.pop();
                else if (curChar >= '0' && curChar <= '9' || curChar == '-') {
                    int start = i;
                    // 找到根元素的值
                    while (i < s.length() - 1 && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9') {
                        i++;
                    }
                    TreeNode root = new TreeNode(Integer.parseInt(s.substring(start, i+1)));
                    // 获取父节点
                    if (!stack.isEmpty()) {
                        TreeNode parent = stack.peek();
                        if (parent.left == null) parent.left = root;
                        else parent.right = root;
                    }
                    // 压桟
                    stack.push(root);
                }
            }
            if (stack.isEmpty()) return null;

            return stack.peek();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}