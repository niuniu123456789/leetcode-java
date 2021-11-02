package first.leetcode.no25;

/**
 * @author lvy
 * @date 2021/9/13 15:45
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        //!!!
        dummy.next = head;

        ListNode prev = dummy;
        ListNode end = dummy;

        while (end.next != null) {

            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }

            if (end == null){
                break;
            }

            ListNode start = prev.next;
            ListNode endNext = end.next;

            end.next = null;

            prev.next = reverse(start);

            start.next = endNext;

            prev = start;
            end = prev;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}