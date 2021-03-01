package leetcode.tree.medium;

import java.util.Arrays;

public class Solution_106 {
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = build(inorder, 0, postorder.length - 1, postorder, postorder.length - 1);
        return root;
    }
    private TreeNode build(int[] inorder, int left, int right, int[] postorder, int postIndex){
//        System.out.println("inorder = " + Arrays.toString(inorder) + ", left = " + left + ", right = " + right + ", postorder = " + Arrays.toString(postorder) + ", postIndex = " + postIndex);
        if(left == right){
            return new TreeNode(inorder[left]);
        }
        int rootIndex = getIndex(inorder, left, right, postorder[postIndex]);
        TreeNode root = new TreeNode(inorder[rootIndex]);

        TreeNode leftNode = null;
        if(rootIndex - 1>=0 && left <= rootIndex-1){
            leftNode = build(inorder, left, rootIndex-1, postorder, postIndex - (right - rootIndex) -1);
        }
        TreeNode rightNode = null;
        if(rootIndex + 1<inorder.length && rootIndex + 1 <= right){
           rightNode  = build(inorder, rootIndex + 1, right, postorder, postIndex - 1);
        }

        root.left = leftNode;
        root.right = rightNode;

        return root;


    }

    private int getIndex(int[] inorder, int left, int right, int rootValue) {
        for (int i = left; i <= right; i++) {
            if(inorder[i] == rootValue){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new Solution_106().buildTree(new int[]{1,2,3,4}, new int[]{3, 2, 4, 1});
        System.out.println(treeNode.val);

    }
}
