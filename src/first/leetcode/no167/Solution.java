package first.leetcode.no167;

/**
 * @author lvy
 * @date 2021/9/16 17:05
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right){
            int sum = numbers[left] + numbers[right];
            if (sum == target){
                /**
                 * 题目要求：numbers 的下标 从 1 开始计数
                 * 是计数 ，最后left,right结果需要 +1
                 */
                return new int[]{left + 1,right + 1};
            }else if (sum < target){
                left ++;
            }else{
                right --;
            }
        }
        return null;
    }
}
