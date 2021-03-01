package seatwork.one;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15 {
    static class Node implements Comparable<Node> {
        int value;
        public Node(int value){
            this.value = value;
        }
        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        Node[][] arr = new Node[size][];
        for (int i = 0; i < size; i++) {
            arr[i] = new Node[in.nextInt()];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = new Node(in.nextInt());
            }
        }

        for (int i = 0; i < arr.length; i++) {
            calculate(arr[i]);
        }
    }

    private static void calculate(Node[] arr) {
//        System.out.println("==========================");
        handle(arr);

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            while(arr[i].value - 1 != i){
//                System.out.println("i = "+i+",arr[i]-1 = "+(arr[i]-1));
                swap(arr,i , arr[i].value - 1);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void handle(Node[] arr) {
        Node[] temp = new Node[arr.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            temp[i].value = i+1;
        }
    }

    private static void swap(Node[] arr, int i, int j) {
        Node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
