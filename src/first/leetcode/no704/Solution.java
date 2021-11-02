package first.leetcode.no704;

/**
 * @author lvy
 * @date 2021/9/16 16:40
 */
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length -1;
        /**
         * 在target 的值为nums[0]，nums[nums.length -]时，
         * left == right
         */
        while (left <= right){
            int mid = left + (right - left)/ 2;
            if (nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return -1;
    }
}
