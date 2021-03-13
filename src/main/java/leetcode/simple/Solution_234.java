package leetcode.simple;

/**
 * 回文链表
 */
public class Solution_234 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;

        ListNode slow = head;
        ListNode current = head;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            // 翻转链表
            current = slow;
            slow = slow.next;
            current.next = pre;
            pre = current;

        }

        // 若 fast == null，则说明链表长度为偶数，此时 slow 正好位于中心偏右的一个节点，正好赋值给 fast；
        // 若 fast == null，则说明链表长度为奇数，此时 slow 位于正中心，需要往下走一个节点赋值个 fast
        fast = fast == null ? slow : slow.next;
        slow = current;


        // 此时 current 和 fast 为对称节点但链表传递方向相反

        while (fast != null) {
            if (slow.val != fast.val) {
                return false;
            }

            slow = slow.next;
            fast = fast.next;
        }


        return true;
    }
}
