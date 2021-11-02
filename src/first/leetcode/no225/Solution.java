package first.leetcode.no225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lvy
 * @date 2021/10/3 15:30
 */
class MyStack {
    Queue<Integer> masterQueue;
    Queue<Integer> assistQueue;

    public MyStack() {
        this.masterQueue = new LinkedList<>();
        this.assistQueue = new LinkedList<>();
    }

    public void push(int x) {
        assistQueue.offer(x);
        while (!masterQueue.isEmpty()){
            assistQueue.offer(masterQueue.poll());
        }
        Queue<Integer> tempQueue = masterQueue;
        masterQueue = assistQueue;
        assistQueue = tempQueue;
    }

    public int pop() {
        return masterQueue.poll();
    }

    public int top() {
        return masterQueue.peek();
    }

    public boolean empty() {
        return masterQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
