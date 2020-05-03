package leetcode.editor.cn;

//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组


public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        // todo
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        System.out.println(solution.buildTree(preorder, inorder));
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
    class Solution {
        /**
         * 思考问题拆解, 前序遍历: 第一个节点总是根节点, 中序遍历: 第一个节点总是左子节点
         * 这样就找到了第一个根节点和第一个左子节点, 除去这两个节点剩下的分别是前序和中序遍历的右子树
         *
         * 找重复: 前序遍历右子树中、第一个节点是根的右子节点; 中序遍历、第一个节点是第一个右子节点的左子节点
         *
         * 以此、可以转化成递归来解
         */
        public class TreeNode {
            TreeNode left;
            TreeNode right;
            int val;
            TreeNode(int val) {
                this.val = val;
            }
        }
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
        }

        private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
            // preorder为空, 直接返回null
            if (p_start == p_end) return null;

            int root_val = preorder[p_start];
            TreeNode root = new TreeNode(root_val);

            // 在中序遍历中找到根节点
            int i_root_index = 0;
            for (int i = i_start; i<i_end; i++) {
                if (root_val == inorder[i]) {
                    i_root_index = i;
                    break;
                }
            }
            int leftNum = i_root_index - i_start;
            // 递归树构造左子树
            root.left = buildTreeHelper(preorder, p_start+1, p_start+leftNum+1, inorder, i_start, i_root_index);
            // 递归构造右子树
            root.right = buildTreeHelper(preorder, p_start+leftNum+1, p_end, inorder, i_root_index+1, i_end );
            return root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}