package first.leetcode.no232;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lvy
 * @date 2021/10/3 16:15
 */
class MyQueue {
    Deque<Integer> masterStack;
    Deque<Integer> assistStack;

    public MyQueue() {
        masterStack = new LinkedList<>();
        assistStack = new LinkedList<>();
    }

    public void push(int x) {
        masterStack.push(x);
    }

    public int pop() {
        if (assistStack.isEmpty()){
            while (!masterStack.isEmpty()){
                assistStack.push(masterStack.pop());
            }
        }
        return assistStack.pop();
    }

    public int peek() {
        if (assistStack.isEmpty()){
            while (!masterStack.isEmpty()){
                assistStack.push(masterStack.pop());
            }
        }
        return assistStack.peek();
    }

    public boolean empty() {
        return masterStack.isEmpty() && assistStack.isEmpty();
    }
}
