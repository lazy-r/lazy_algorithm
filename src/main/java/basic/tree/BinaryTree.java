package basic.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T> implements MyTree<T>{
    private T value;
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTree(T value, BinaryTree<T> left, BinaryTree<T> right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BinaryTree(T value){
        this(value, null, null);
    }



    public BinaryTree(T[] arr){
        arr2Tree(arr);
    }

    @Override
    public MyTree<T> arr2Tree(T[] arr){
        int layer = (int)(Math.log(arr.length)/Math.log(2)+1);


        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(this);
        int index = 0;
        this.value = arr[index++];

        for (int i = 0; i < layer; i++) {
            int nodeNum = (int)Math.pow(2,i);

            for (int j = 0; j < nodeNum&&!queue.isEmpty(); j++) {
                BinaryTree tree = queue.poll();
                if(index < arr.length){
                    tree.left = new BinaryTree(arr[index++]);
                    queue.add(tree.left);
                }else {
                    break;
                }
                if(index < arr.length){
                    tree.right = new BinaryTree(arr[index++]);
                    queue.add(tree.right);
                }else {
                    break;
                }
            }


        }


        return this;
    }


    @Override
    public String toString() {
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(this);
        StringBuffer buffer = new StringBuffer();
        int layer = getLayer();
        int index = 0;
        int currentLayer = 1;

        while (!queue.isEmpty()){
            BinaryTree tree = queue.poll();
            buffer.append(tree.value+" ");
            if(tree.left != null){
                queue.add(tree.left);
            }
            if(tree.right != null){
                queue.add(tree.right);
            }
            index++;
            if(index >= (int)Math.pow(2, currentLayer) - 1){
                currentLayer++;
                buffer.append("\n");
            }

        }


        return buffer.toString();
    }


    @Override
    public int getLayer(){
        int layer = 0;
        BinaryTree tree = this;
        while (tree != null){
            tree = tree.left;
            layer++;
        }
        return layer;
    }

    @Override
    public int getNodeNum() {
        return -1;
    }

    @Override
    public T[] tree2Arr() {
        return null;
    }

    @Override
    public void preTraversal_Iteration() {
        System.out.println("迭代-前序遍历 ");
        Stack<BinaryTree> stack = new Stack<>();
        stack.add(this);
        BinaryTree tree = null;

        while (!stack.isEmpty()){
            // 1、输出根元素
            tree = stack.pop();
            System.out.print(tree.value + " ");
            // 2、若根元素的右子树不为空，则将右子树入栈
            if(tree.right != null){
                stack.add(tree.right);
            }
            // 3、若根元素的左子树不为空，则将左子树入栈
            if (tree.left != null){
                stack.add(tree.left);
            }
        }
        System.out.println();
    }

    @Override
    public void inTraversal_Iteration() {
        System.out.println("迭代-中序遍历");
        Stack<BinaryTree> stack = new Stack<>();

        // 辅助节点
        BinaryTree tree = this;


        while (tree != null || !stack.isEmpty()) {
            while (tree != null) {
                // 1、当前节点不为null，将当前节点入栈等到该节点的左子树全部处理完后在处理当前节点
                stack.add(tree);
                // 2、先处理左孩子节点
                tree = tree.left;
            }
            // 3、弹出要处理的节点
            BinaryTree temp = stack.pop();
            // 4、输出要处理节点
            System.out.print(temp.value+" ");
            // 5、处理要处理节点的右子树
            tree = temp.right;
        }



    }

    @Override
    public void postTraversal_Iteration() {
        System.out.println("迭代-后序遍历");
        Stack<BinaryTree> src = new Stack<>();
        Stack<BinaryTree> res = new Stack<>();
        src.add(this);


        while (!src.isEmpty()) {
            BinaryTree tree = src.pop();
            res.push(tree);
            if (tree.left != null) {
               src.push(tree.left);
            }
            if (tree.right != null) {
                src.push(tree.right);
            }
        }

        while (!res.isEmpty()){
            System.out.print(res.pop().value+" ");
        }
    }


    @Override
    public void preTraversal_Recursion() {
        System.out.println("递归-前序遍历");
        preTraversal_Recursion(this);
        System.out.println();
    }

    @Override
    public void inTraversal_Recursion() {
        System.out.println("递归-中序遍历");
        inTraversal_Recursion(this);
        System.out.println();
    }

    @Override
    public void postTraversal_Recursion() {
        System.out.println("递归-后序遍历");
        postTraversal_Recursion(this);
        System.out.println();
    }

    private void preTraversal_Recursion(BinaryTree<T> tree){
        if(tree == null){
            return;
        }

        // 1、先输出根元素
        System.out.print(tree.value+" ");
        // 2、再输出左子树元素
        preTraversal_Recursion(tree.left);
        // 3、最后输出右子树元素
        preTraversal_Recursion(tree.right);


    }
    private void inTraversal_Recursion(BinaryTree<T> tree){
        if(tree == null){
            return;
        }

        // 1、先输出左子树元素
        inTraversal_Recursion(tree.left);
        // 2、再输出根元素
        System.out.print(tree.value+" ");
        // 3、最后输出右子树元素
        inTraversal_Recursion(tree.right);
    }
    private void postTraversal_Recursion(BinaryTree<T> tree){
        if(tree == null){
            return;
        }

        // 1、先输出左子树元素
        postTraversal_Recursion(tree.left);
        // 2、然后输出右子树元素
        postTraversal_Recursion(tree.right);
        // 3、最后输出根元素
        System.out.print(tree.value+" ");
    }

}
