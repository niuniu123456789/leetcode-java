package Second.leetcode.no402;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author lvy
 * @date 2021/10/13 17:15
 */
class Solution {
    public String removeKdigits(String num, int k) {

        //将字符串 转化 为字符数组
        char ch[] = num.toCharArray();
        //将字符数组 转化 为链表
        LinkedList<Integer> linklist=new LinkedList(Arrays.asList(ch));

        //若 字符串长度 ==0 || <= k, 则返回 0
        if (ch.length == 0 || ch.length <= k){
            return "0";
        }


        for (int i = 0; i < linklist.size(); i++) {

            // 待移除元素 个数为 0，返回结果
            if (k <= 0){
                return num;
            }

            //比较 第i个 与第i+1个元素，若i>i+1,则移除 num[i]
            //使用数组查找
            if ( Integer.parseInt(linklist.get(i).toString()) >  Integer.parseInt(linklist.get(i).toString()) ){
                //使用 链表 删除
                linklist.remove(i);
                k--;
            }

        }

        return linklist.toString();
    }
}
