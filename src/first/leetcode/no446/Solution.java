package first.leetcode.no446;

/**
 * @author lvy
 * @date 2021/10/8 09:20
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = root.left;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
