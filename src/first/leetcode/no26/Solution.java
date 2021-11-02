package first.leetcode.no26;

/**
 * @author lvy
 * @date 2021/9/27 18:17
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int slow = 0, fast = 1;
        while (fast < nums.length){
            if (nums[slow] == nums[fast]){
                fast++;
            }else {
                nums[slow + 1] = nums[fast];
                slow++;
            }
        }
        return slow + 1;
    }
}
