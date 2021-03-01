package seatwork.one;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main_7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[][] trees = new int[size][];
        for (int i = 0; i < size; i++) {
            int len = in.nextInt();
            trees[i] = new int[len];
            for (int j = 0; j < len; j++) {
                trees[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < size; i++) {
            calculate(trees[i]);
//            sort(trees[i],0, trees[i].length-1);
//            System.out.println(Arrays.toString(trees[i]));
        }


    }

    private static void calculate(int[] tree) {



        int layer = (int)(Math.log(tree.length)/Math.log(2)+1);
        int startIndex = 0;
        for (int i = 0; i < layer; i++) {
            int nodeNum = (int) Math.pow(2,i);
            int endIndex = startIndex+nodeNum < tree.length?(startIndex+nodeNum):tree.length;
            StringBuffer layerStr = new StringBuffer();



            sort(tree, startIndex, endIndex-1);


            Queue<Integer> queue = new LinkedList<>();
            for (int j = startIndex; j < endIndex; j++) {
                if(!queue.contains(tree[j])){
                    layerStr.append(tree[j]+" ");
                    queue.add(tree[j]);
                }
            }
            System.out.println(layerStr.toString().trim());
            startIndex += nodeNum;
        }
    }

    private static void sort(int[] tree, int startIndex, int endIndex) {
        if(startIndex >= endIndex){
            return;
        }
        int pivot = tree[startIndex];

        int left = startIndex;
        int right = endIndex;

        while (left < right){
            while (tree[right] > pivot&&left < right){
                right--;
            }
            tree[left] = tree[right];
            while (tree[left] < pivot&&left < right){
                left++;
            }
            tree[right--] = tree[left];
        }
        tree[left] = pivot;
        sort(tree,startIndex, left-1);
        sort(tree,left+1, endIndex);


    }

    private static void swap(int[] tree, int left, int right) {
        int temp = tree[left];
        tree[left] = tree[right];
        tree[right] = temp;
    }

}
