package seatwork.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[][] arr = new int[size][];
        for (int i = 0; i < arr.length; i++) {
            int len = in.nextInt();
            arr[i] = new int[len];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            calculate(arr[i]);
        }

    }

    static class Node implements Comparable<Node>{
        int value;
        int count;
        public Node(int value){
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.count == o.count?this.value - o.value:o.count - this.count;
        }

        @Override
        public String toString() {
            return "["+value+","+count+"]";
        }
    }

    private static void calculate(int[] arr) {
        int max = getMax(arr);
        int min = getMin(arr);

        Node[] nodes = new Node[max - min + 1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(min + i);
        }

        for (int i = 0; i < arr.length; i++) {
            nodes[arr[i] - min].count++;
        }


        Arrays.sort(nodes);

        StringBuffer buffer = new StringBuffer();
        for (Node node : nodes) {
            while (node.count-- > 0){
                buffer.append(node.value+" ");
            }
        }

        System.out.println(buffer.toString().trim());

    }

    private static void sort(int[][] arr, int left, int right){
        if(left >= right){
            return;
        }

        int value = arr[left][0];
        int count = arr[left][1];
        int leftIndex = left;
        int rightIndex = right;

        while (leftIndex < rightIndex){
            while (arr[rightIndex][1] < count && leftIndex < rightIndex){
                rightIndex--;
            }

            assignment(arr, leftIndex, rightIndex);
            while (arr[leftIndex][1] > count && leftIndex < rightIndex){
                leftIndex++;
            }
            assignment(arr, rightIndex--, leftIndex);
        }
        arr[leftIndex][0] = value;
        arr[leftIndex][1] = count;
        sort(arr, left, leftIndex-1);
        sort(arr, leftIndex+1, right);
    }

    private static void assignment(int[][] arr, int index1, int index2) {
        arr[index1][0] = arr[index2][0];
        arr[index1][1] = arr[index2][1];
    }

    private static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            min = min < arr[i]?min:arr[i];
        }
        return min;
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = max > arr[i]?max:arr[i];
        }
        return max;
    }
}
