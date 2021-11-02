package first.leetcode.no283;

/**
 * @author lvy
 * @date 2021/9/27 22:17
 */
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0){
            return ;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length){
            if (nums[fast] != 0){
                nums[slow ++] = nums[fast];
            }
            fast ++;
        }
        for (;slow < nums.length; slow++){
            nums[slow] = 0;
        }
    }
}