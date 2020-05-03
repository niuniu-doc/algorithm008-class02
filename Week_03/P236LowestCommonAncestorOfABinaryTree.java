package leetcode.editor.cn;

//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。”
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
//
//
// 示例 1:
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
//
// 示例 2:
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
//
// 说明:
// 所有节点的值都是唯一的。
// p、q 为不同节点且均存在于给定的二叉树中。
//
// Related Topics 树

class Solution {
    TreeNode res;
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    /**
     * 参考了官方题解, 方法一
     * 1. 从根节点开始遍历树
     * 2. 若当前节点是p或者q中的一个, 将遍历mid标记为true, 继续搜索左右分支的另一个节点
     * 3. 若左分支或者右分支中的任何一个返回true, 表示在下边找到了两个节点中的任意一个
     * 4. 若在遍历的任何节点上, left、right、或者mid三个标记中的任意两个变为true,
     *    则表示找到了节点p和q的最近公共祖先
     * 时间复杂度 O(N), 最坏情况下、需要访问二叉树的所有节点
     * 空间复杂度 O(N), 栈递归使用的最大空间为N
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;
        boolean left = dfs(node.left, p, q);
        boolean right = dfs(node.right, p, q);
        boolean mid = (node == p || node == q);
        if (mid ? (left || right) : (left && right))
            res = node;
        return left || right || mid;
    }
}