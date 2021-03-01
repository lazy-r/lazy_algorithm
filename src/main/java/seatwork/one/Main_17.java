package seatwork.one;

import java.util.Arrays;
import java.util.Scanner;

public class Main_17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        in.nextLine();
        for (int i = 0; i < size; i++) {
            String nums = in.nextLine();
//            System.out.println("nums = "+nums);
            String[] strArr = nums.split(" ");
            int[] arr = new int[strArr.length];
            for (int j = 0; j < strArr.length; j++) {
                arr[j] = Integer.parseInt(strArr[j]);
            }


            bubbleSort(arr);


            System.out.println(Arrays.toString(arr)
                    .replace("[","")
                    .replace("]","")
                    .replace(",",""));
        }


    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 1、判断该次循环是否有序
            boolean ordered = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                    ordered = false;
                }
            }
            // 2、若有序，则停止排序
            if (ordered){
                break;
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


}
