package first.leetcode.no654;

import java.util.Arrays;

/**
 * 超出时间限制
 * @author lvy
 * @date 2021/10/10 16:30
 */
class Solution2 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        //输出数组中 的最大值 及 最大值下标
        int max = 0,index = 0;
        for (int i = 0; i<nums.length; i++){
            if (nums[i] > max){
                max = nums[i];
                index = i;
            }
        }

        //构造 根节点
        TreeNode root = new TreeNode(max);
        //递归 构造左右子树
        int[] leftNums = new int[nums.length];
        for(int i = 0; i < index; i++){
            leftNums[i] = nums[i];
        }
        root.left = constructMaximumBinaryTree(leftNums);


        int[] rightNums = new int[nums.length];
        for(int j = index + 1; j < index; j++){
            rightNums[j - index -1] = nums[j];
        }
        root.right = constructMaximumBinaryTree(rightNums);

        return root;
    }
}

// 超出时间限制

//构造 根节点
// TreeNode root = new TreeNode(max);
//     //递归 构造左右子树
//     int[] leftNums = new int[nums.length];
//         System.arraycopy(leftNums,0 , nums, 0, index);
//                 root.left = constructMaximumBinaryTree(leftNums);
//
//                 int[] rightNums = new int[nums.length];
//                 System.arraycopy(rightNums,0 , nums, index + 1, nums.length - index -2);
//                 root.right = constructMaximumBinaryTree(rightNums);
//
//                 return root;