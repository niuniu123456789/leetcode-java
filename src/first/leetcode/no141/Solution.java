package first.leetcode.no141;

/**
 * @author lvy
 * @date 2021/9/13 17:34
 */
class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }

        ListNode slow = head,fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow){
                return true;
            }
        }

        return false;
    }
}
