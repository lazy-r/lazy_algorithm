package seatwork.one;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main_19 {
    private static Stack<Integer> leftStack = new Stack<>();
    private static Stack<Integer> rightStack = new Stack<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        sort(arr);
        System.out.println(Arrays.toString(arr)
                .replace("[","")
                .replace("]","")
                .replace(",",""));
    }
    private static void sort(int[] arr){
        update(0, arr.length-1);



        while (!leftStack.isEmpty() && !rightStack.isEmpty()){
            int left = leftStack.pop();
            int right = rightStack.pop();

            int leftIndex = left;
            int rightIndex = right;

            int pivot = arr[leftIndex];

            while (leftIndex < rightIndex){
                while (arr[rightIndex] > pivot && leftIndex < rightIndex){
                    rightIndex--;
                }
                arr[leftIndex] = arr[rightIndex];
                while (arr[leftIndex] < pivot && leftIndex < rightIndex){
                    leftIndex++;
                }
                arr[rightIndex--] = arr[leftIndex];
            }
            arr[leftIndex] = pivot;
            update(left, leftIndex-1);
            update(leftIndex+1, right);

        }

    }
    private static void update(int left, int right){
        if(left < right){
            leftStack.push(left);
            rightStack.push(right);
        }

    }
}
