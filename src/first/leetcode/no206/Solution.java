package first.leetcode.no206;

/**
 * @author lvy
 * @date 2021/9/13 14:57
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode nodePrev = null;
        while(head.next != null){
            ListNode nodeNext = head.next;
            head.next = nodePrev;
            nodePrev = head;
            head = nodeNext;

        }
        //System.out.println(head, head.next);
        return nodePrev ; //head=NULL;
    }
}
