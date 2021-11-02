package first.leetcode.no114;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lvy
 * @date 2021/10/8 09:39
 */
class Solution {
    public void flatten(TreeNode root) {
        //将二叉树 拉成 一个链表
        if (root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);

        //1.左右子树 已经 被拉平
        TreeNode left = root.left;
        TreeNode right = root.right;

        //2.将左子树 拉成为 右子树
        root.right = root.left;
        root.left = null;

        //3.将原先的(大或小)右子树 接到 现在的右子树的末端
        TreeNode p = root;
        while ( p.right != null){
            p = p.right;
        }
        p.right = right;
    }
}

