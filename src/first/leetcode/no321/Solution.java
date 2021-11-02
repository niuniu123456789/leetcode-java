package first.leetcode.no321;

/**
 * @author lvy
 * @date 2021/10/3 15:02
 */
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        //寻找nums的最大值 及其索引
        int max_nums1 = 0;
        int max1 =0;
        for (int i=0; i<nums1.length; i++){
            if (nums1[i] > max_nums1){
                max_nums1 = nums1[i];
                max1 = i;
            }
        }

        int max_nums2 = 0;
        int max2 =0;
        for (int i=0; i<nums2.length; i++){
            if (nums2[i] > max_nums1){
                max_nums2 = nums2[i];
                max2 = i;
            }
        }

        int max = max_nums1 > max_nums2 ? max_nums1 : max_nums2;
        return new int[]{max};

    }
}
