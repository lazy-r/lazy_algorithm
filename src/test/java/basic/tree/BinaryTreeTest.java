package basic.tree;

import basic.search.BinarySearch;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {
    @Test
    public void arr2Tree(){
        BinaryTree<Integer> tree = new BinaryTree<>(new Integer[]{1,2,3,4,5,6,7,8,9});
        System.out.println(tree);
//        tree.preTraversal_Recursion();
//        tree.preTraversal_Iteration();
        tree.inTraversal_Recursion();
        tree.inTraversal_Iteration();
//        tree.postTraversal_Recursion();
//        tree.postTraversal_Iteration();
    }

}
