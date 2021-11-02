package first.leetcode.no316;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证 返回结果的字典序最小
 * 4edddddddd8（要求不能打乱其他字符的相对位置）。
 * @author lvy
 * @date 2021/9/29 11:44
 */
class Solution {
    public String removeDuplicateLetters(String s) {
        //部分递增栈
        Deque<Character> monoStack = new LinkedList<>();
        //剩余字符串的出现次数
        int[] hasNum = new int[26];
        //栈内是否含有字符
        boolean[] hasStack = new boolean[26];

        for (Character ch : s.toCharArray()){
            hasNum[ch - 'a']++;
        }

        for (int i=0; i<s.length(); i++){
            int asciiOffset = s.charAt(i) - 'a';
            if (!hasStack[asciiOffset]){
                while (!monoStack.isEmpty() && monoStack.peek() - 'a' > asciiOffset){
                    if (hasNum[monoStack.peek() - 'a'] > 0){
                        //维护hasStack
                        hasStack[monoStack.peek() - 'a'] = false;
                        monoStack.pop();
                    }else {
                        break;
                    }
                }
                monoStack.push((char) (asciiOffset + 'a'));
                hasStack[asciiOffset] = true;
            }
            hasNum[asciiOffset]--;
        }

        StringBuilder result = new StringBuilder();
        monoStack.forEach(result::append);
        return result.reverse().toString();
    }

}