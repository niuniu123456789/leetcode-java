package first.leetcode.no76;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvy
 * @date 2021/9/16 17:29
 */
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        for (char c: t.toCharArray()){
            needMap.merge(c,1,Integer::sum);
        }

        int l = 0, r = 0, valid = 0, size = Integer.MAX_VALUE;
        int start = 0, len = Integer.MAX_VALUE;

        while (r < s.length()){
            //移入窗口字符
            char in = s.charAt(r);
            //滑动窗口
            r++;
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
            while (valid == needMap.size()){
                //更新最小覆盖字串
                if (r - l < len){
                    start = l;
                    len = r - l;
                }
                //移除窗口字符
                char out = s.charAt(l);
                l++;
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
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}