package first.leetcode.no27;

/**
 * @author lvy
 * @date 2021/9/27 21:37
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = nums.length - 1;
        int temp;
        while (slow <= fast){
            if (nums[slow] == val){
                temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                fast --;
            }else {
                slow ++;
            }
        }
        return fast + 1;
    }
}
