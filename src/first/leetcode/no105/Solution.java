package first.leetcode.no105;

/**
 * @author lvy
 * @date 2021/10/11 11:07
 */
class Solution {
    //主函数
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length -1,
                inorder,0,inorder.length -1);
    }


    //构造二叉树，返回二叉树 根节点
    public TreeNode build(int[] preorder,int preStart, int preEnd,
                          int[] inorder,int inStart,int inEnd){
        //检验数组是否为空
        if (preEnd < preStart || inEnd < inStart){
            return null;
        }

        //1.preOrder[preStart] 就是 二叉树的root元素节点
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootVal = preorder[preStart];
        int index = 0;

        //2.找到 preOrder[preStart] 在 inOrder中的位置
        for (int i = inStart; i <= inEnd; i++){
            if (inorder[i] == rootVal){
                index = i;
                break;
            }
        }

        //3.返回 下次遍历 的左边数组长度
        int leftSize = index - inStart;



        root.left = build(preorder,preStart + 1,
                preStart + leftSize,
                inorder,inStart,index -1);
        root.right = build(preorder,preStart + 1 + leftSize,
                preEnd,
                inorder,index + 1, inEnd);
        return root;
    }
}
