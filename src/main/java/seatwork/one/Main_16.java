package seatwork.one;

import java.util.Arrays;
import java.util.Scanner;

public class Main_16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        in.nextLine();
        int[][] arr = new int[size][];
        for (int i = 0; i < size; i++) {
            String nums = in.nextLine();
//            System.out.println("nums = "+nums);
            String[] strArr = nums.split(" ");
            arr[i] = new int[strArr.length];
            for (int j = 0; j < strArr.length; j++) {
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            sort(arr[i]);
            System.out.println(Arrays.toString(arr[i])
                                .replace("[","")
                                .replace("]","")
                                .replace(",",""));
        }
    }

    private static void sort(int[] arr){
        // 1、在前i-1个数字为有序的前体下，使第i个数字放到该放的位置
        for (int i = 1; i < arr.length; i++) {
            // 2、记住第i个数字
            int temp = arr[i];
            // 3、将大于第i个数字的数字向后移动一位
            int j = i-1;
            for (; j >= 0; j--) {
                if(arr[j] > temp){
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = temp;
        }
    }
}
