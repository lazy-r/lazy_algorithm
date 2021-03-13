package leetcode.simple;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 二叉树的最小深度
 */
public class Solution_111 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();


        // 将起点加入队列
        queue.add(root);
        // 记录深度
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();


            // 将当前队列的节点往下扩散
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();

                // 判断是否为叶子节点
                if (currentNode.left == null && currentNode.right == null) {
                    return depth;
                }

                // 将非叶子节点的字节的加入队列
                if (currentNode.left != null) {
                   queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                   queue.add(currentNode.right);
                }
            }

            // 层数加1
            depth++;
        }

        return depth;
    }
}
