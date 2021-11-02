package first.leetcode.no19;

import java.util.List;

/**
 * @author lvy
 * @date 2021/9/15 16:36
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //ListNode(val,
        ListNode dummy = new ListNode(0,head);
        ListNode slow = dummy, fast = head;
        for (int i=0; i<n; i++){
           fast = fast.next;
        }

        while (fast != null ){
            slow = slow.next;
            fast = fast.next;
        }


        slow.next = slow.next.next;

        return dummy.next;
    }
}

//  return head;
//输入 为[1]，head节点 已经不在该 链表 里

//return dummy;
//返回链表 会增加dummy节点
