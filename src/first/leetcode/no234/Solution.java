package first.leetcode.no234;

/**
 * @author lvy
 * @date 2021/9/13 18:03
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head,fast = head;

        ListNode prev = head, prevPrev = null;

        while (fast !=null && fast.next != null){
            fast = fast.next.next;

            prev = slow;
            slow = slow.next;
            prev.next = prevPrev;
            prevPrev = prev;



        }

        //总个数为奇数
        if (fast != null){
            slow = slow.next;
        }

        while(prev != null && slow != null){
            if (prev.val != slow.val){
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }

        return true;
    }
}
