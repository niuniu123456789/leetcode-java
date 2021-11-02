package first.codinginterviews2.no22;

/**
 * @author lvy
 * @date 2021/9/15 10:21
 */
class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (true){
            if (fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }

        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
// 在fast == null 的情况下会执行 下一个方法
//      while (fast != null && fast != slow){
//              if (fast.next == null){
//              return null;
//              }
//              fast = fast.next.next;
//              slow = slow.next;
//              }


// fast == slow 必须在 fast == fast.next.next; slow == slow.next; 的后面，第一步一定相同
//while (true){
//        if (fast == null || fast.next == null){
//        return null;
//        }
//        if (fast == slow){
//        break;
//        }
//        fast = fast.next.next;
//        slow = slow.next;
//        }