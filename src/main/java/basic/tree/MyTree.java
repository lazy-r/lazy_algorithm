package basic.tree;

public interface MyTree<T> {
    MyTree arr2Tree(T[] arr);
    int getLayer();
    int getNodeNum();
    T[] tree2Arr();
    void preTraversal_Iteration();
    void inTraversal_Iteration();
    void postTraversal_Iteration();
    void preTraversal_Recursion();
    void inTraversal_Recursion();
    void postTraversal_Recursion();


}
