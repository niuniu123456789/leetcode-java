package first.leetcode.no344;

/**
 * @author lvy
 * @date 2021/9/16 17:19
 */
public class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length -1;
        char a;
        while (left <= right){
            a = s[left];
            s[left] = s[right];
            s[right] = a;

            left ++;
            right --;
        }
    }
}
