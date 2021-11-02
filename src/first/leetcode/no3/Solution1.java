package first.leetcode.no3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvy
 * @date 2021/9/24 14:15
 */
class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> windowMap = new HashMap<>();
        int left = 0, right = 0,valid = 0;

        if (s.length() == 0){
            return 0;
        }

        while (right < s.length()){
            char in = s.charAt(right);
            right++;
            windowMap.merge(in,1,Integer::sum);

            while (windowMap.get(in)>1){
                char out = s.charAt(left);
                left++;
                windowMap.merge(out,-1,Integer::sum);
            }
            valid = valid > right -left ? valid : right - left;
        }

        return valid;
    }
}
