package leetcode.medium;

/**
 * 环路检测
 */
public class Interview_02_08 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            // 快指针跑两步，慢指针跑一步
            fast = fast.next.next;
            slow = slow.next;

            // 若快慢指针相遇，则说明快指针比慢指针多走了一倍的路，而多走的这一倍路就是环的长度
            if (slow == fast) {
                break;
            }
        }


        // 让slow回到起点，与fast以同样的速度前进
        slow = head;
        // 若无环，则 fast 会走到尽头（fast == null）；若有环，则 fast 和 slow 相遇的节点就是环的起点
        while (fast != null && slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }


        return fast;
    }


}
