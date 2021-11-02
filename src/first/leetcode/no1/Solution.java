package first.leetcode.no1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvy
 * @date 2021/9/25 16:37
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] retu = new int[0];
        for(int i = 0; i<nums.length ; i++){
            int ret = target - nums[i];
            for(int j=(i+1)%nums.length ; j != i ; j = (j+1)%nums.length){
                if(nums[j] == ret){
                    retu = new int[]{i,j};
                    return retu;
                }
            }
        }
        return retu;
    }
}
