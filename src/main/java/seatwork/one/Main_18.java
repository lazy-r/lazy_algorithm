package seatwork.one;

import java.util.Arrays;
import java.util.Scanner;

public class Main_18 {
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
        // 1、获取最大最小值
        int max = getMax(arr);
        int min = getMin(arr);
        // 2、创建长度为min到max之间的数字的个数的"桶"
        int[] bucket = new int[max - min + 1];

        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i] - min]++;
        }

        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0){
                arr[index++] = min+i;
                bucket[i]--;
            }
        }

    }

    private static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            min = arr[i]<min?arr[i]:min;
        }
        return min;
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = arr[i]>max?arr[i]:max;
        }
        return max;
    }
}
