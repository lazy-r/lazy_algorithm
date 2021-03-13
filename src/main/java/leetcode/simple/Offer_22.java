package leetcode.simple;

/**
 * 链表中倒数第k个节点
 */
public class Offer_22 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;

        // 先让 fast 节点跑 k 步，若在 k 步之内就已经到头，则说明无倒数第 k 个节点
        while (fast != null && k > 0){
            fast = fast.next;
            k--;
        }

        if (k > 0) {
            return null;
        }


        // 让 slow 和 fast 同时跑，fast 跑到头使，slow 就是倒数第 k 个节点
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
