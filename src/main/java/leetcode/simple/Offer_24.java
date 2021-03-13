package leetcode.simple;

/**
 * 反转链表
 */
public class Offer_24 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode next = head;
        ListNode current = head;
        ListNode pre = null;

        while (next != null) {
            current = next;
            next = next.next;
            current.next = pre;
            pre = current;
        }

        return current;

    }
}
