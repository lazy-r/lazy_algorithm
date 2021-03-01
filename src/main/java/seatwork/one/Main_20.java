package seatwork.one;

import java.util.*;

public class Main_20 {
    private static Stack<Integer> leftStack = new Stack<>();
    private static Stack<Integer> rightStack = new Stack<>();
    private static Queue<Integer> leftQueue = new LinkedList<>();
    private static Queue<Integer> rightQueue = new LinkedList<>();

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
        pushQueue(0, arr.length-1);
        while (!leftQueue.isEmpty()&&!rightQueue.isEmpty()){
            int left = leftQueue.poll();
            int right = rightQueue.poll();
            pushStack(left, right);
            int mid = (left+right)/2;
            pushQueue(left,mid);
            pushQueue(mid+1,right);
        }

        int[] temp = new int[arr.length];
        while (!leftStack.isEmpty()&&!rightStack.isEmpty()){
            merge(arr, leftStack.pop(), rightStack.pop(), temp);
        }


    }

    private static void pushQueue(int left, int right) {
        if(left < right){
            leftQueue.add(left);
            rightQueue.add(right);
        }

    }

    private static void pushStack(int left, int right){
        if(left < right){
            leftStack.push(left);
            rightStack.push(right);
        }
    }


    private static void merge(int[] arr, int left, int right, int[] temp){
        int mid = (left + right)/2;
        int leftIndex = left;
        int rightIndex = mid+1;

        int tempIndex = leftIndex;
        while (leftIndex <= mid&&rightIndex <= right){
            if(arr[leftIndex] <= arr[rightIndex]){
                temp[tempIndex++] = arr[leftIndex++];
            }else {
                temp[tempIndex++] = arr[rightIndex++];
            }
        }

        while (leftIndex <= mid){
            temp[tempIndex++] = arr[leftIndex++];
        }
        while (rightIndex <= right){
            temp[tempIndex++] = arr[rightIndex++];
        }

        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

    }
}
