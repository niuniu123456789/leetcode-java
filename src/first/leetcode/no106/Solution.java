package first.leetcode.no106;

import first.leetcode.no106.TreeNode;

/**
 * 没有看题解，自己做出的，开心开心
 * @author lvy
 * @date 2021/10/11 17:34
 */

class Solution {

    //主函数
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder,0,postorder.length -1,
                inorder,0,inorder.length -1);
    }


    //构造二叉树，返回二叉树 根节点
    public TreeNode build(int[] postorder, int postStart, int postEnd,
                          int[] inorder, int inStart, int inEnd){
        //检验数组是否为空
        if (postEnd < postStart || inEnd < inStart){
            return null;
        }

        //1.preOrder[preStart] 就是 二叉树的root元素节点
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootVal = postorder[postEnd];
        int index = 0;

        //2.找到 preOrder[preStart] 在 inOrder中的位置
        for (int i = inStart; i <= inEnd; i++){
            if (inorder[i] == rootVal){
                index = i;
                break;
            }
        }

        //3.返回 下次遍历 的左边数组长度
        int leftSize = index - inStart - 1;


        root.left = build(postorder,postStart,
                postStart + leftSize,
                inorder,inStart,index -1);
        root.right = build(postorder,postStart + 1 + leftSize,
                postEnd - 1,
                inorder,index + 1, inEnd);
        return root;
    }
}
