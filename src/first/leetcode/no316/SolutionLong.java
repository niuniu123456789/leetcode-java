package first.leetcode.no316;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lvy
 * @date 2021/10/2 18:45
 */
public class SolutionLong {
    public String removeDuplicateLetters(String s) {
        // 分段单调递增栈，每一段单调递增，存储 charIndex，即 char - 'a'
        Deque<Character> monoStack = new LinkedList<>();
        // 栈中是否有某个字母
        boolean[] stackHas = new boolean[26];
        // 字符串中剩余字母对应个数
        int[] charNums = new int[26];
        // 填充 charNums
        for (char character : s.toCharArray()) {
            charNums[character - 'a'] += 1;
        }

        for (int i = 0; i < s.length(); i++) {
            int asciiOffset = s.charAt(i) - 'a';
            //判断栈内元素不重复
            if (!stackHas[asciiOffset]) {
                while (!monoStack.isEmpty() && asciiOffset < monoStack.peek() - 'a') {
                    int top = monoStack.peek() - 'a';
                    if (charNums[top] > 0) {
                        monoStack.pop();
                        //维护
                        stackHas[top] = false;
                        // 后续字符串中没有栈顶字符了，拒绝出栈，跳出
                    } else {
                        break;
                    }
                }
                monoStack.push((char) (asciiOffset + 'a'));
                stackHas[asciiOffset] = true;
            }
            charNums[asciiOffset] -= 1;
        }
        StringBuilder result = new StringBuilder();
        monoStack.forEach(result::append);
        return result.reverse().toString();
    }
}
