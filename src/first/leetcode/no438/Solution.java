package first.leetcode.no438;

import java.util.*;

/**
 * @author lvy
 * @date 2021/9/24 09:30
 */
// s 包含 p
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        List<Integer> result = new ArrayList<Integer>();

        for (char c: p.toCharArray()){
            needMap.merge(c,1,Integer::sum);
        }

        int left = 0, right = 0, valid = 0;

        while (right < s.length()){
            //移入窗口字符
            char in = s.charAt(right);
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
            while (right - left >= p.length()){

                //更新最小覆盖字串
                if (valid == needMap.size()){
                    result.add(right - p.length());
                }

                //移除窗口字符
                char out = s.charAt(left);
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
        return result;
    }
}
