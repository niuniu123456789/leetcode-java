package first.leetcode.no567;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        for (char c: s1.toCharArray()){
            needMap.merge(c,1,Integer::sum);
        }

        int left = 0, right = 0, valid = 0;

        while (right < s2.length()){
            //移入窗口字符
            char in = s2.charAt(right);
            //滑动窗口
            right++;
            //更新窗口
            if (needMap.containsKey(in)){
                //更新windowMap
                windowMap.merge(in,1,Integer::sum);
                if (needMap.get(in).equals(windowMap.get(in))){
                    //更新valid
                    valid++;
                }
            }

            //判断左窗口是否需要收缩
            while (right - left >= s1.length()){
                //更新最小覆盖字串
                if (valid == needMap.size()){
                    return true;
                }
                //移除窗口字符
                char out = s2.charAt(left);
                left++;
                //更新窗口内数据
                if (needMap.containsKey(out)){
                    //更新valid
                    if (needMap.get(out).equals(windowMap.get(out))){
                        valid--;
                    }
                    //更新windowMap
                    windowMap.merge(out,-1,Integer::sum);
                }

            }
        }
        return false;
    }
}

// while (valid >= needMap.size()){
//         //更新最小覆盖字串
//         if (valid == needMap.size()){
//         return true;
//         }