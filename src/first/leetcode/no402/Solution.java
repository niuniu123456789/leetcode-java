package first.leetcode.no402;

import java.util.Stack;

/**
 * @author lvy
 * @date 2021/9/29 16:53
 */
class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == 0 || num.length() <= k){
            return "0";
        }

        StringBuilder stack = new StringBuilder();
        int remain = num.length() - k;

        for (int i=0; i<num.length(); i++){
            char ch = num.charAt(i);

            while (k>0 && stack.length() !=0 && stack.charAt(stack.length() -1) > ch){
                stack.setLength(stack.length() -1);
                k--;
            }

            if (ch=='0' && stack.length() == 0){
                continue;
            }

            stack.append(ch);
        }
        //String result = stack.substring(0,num.length() - k);
        String result = stack.substring(0,stack.length()-k <1 ?0:stack.length()-k);
        return result.length()==0 ? "0" : result ;
    }

}

    // Stack<Character> stack = new Stack<>();
    // //把字符串 变成 字符数组
    // char[] nums = num.toCharArray();
    //     for (int i=0; i< nums.length; i++){
    //     stack.push(nums[i]);
    //     }
