package seatwork.one;

import java.util.Arrays;
import java.util.Scanner;


public class Main_22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();

        int[][] arr = new int[size][];
        int[][] interval = new int[size][];

        in.nextLine();
        for (int i = 0; i < size; i++) {
            String line = in.nextLine();
            String[] arrStr = line.split(" ");
            arr[i] = new int[arrStr.length];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(arrStr[j]);
            }
            String[] intervalStr = in.nextLine().split(" ");
            interval[i] = new int[intervalStr.length];
            for (int j = 0; j < interval[i].length; j++) {
                interval[i][j] = Integer.parseInt(intervalStr[j]);
            }

        }

        for (int i = 0; i < arr.length; i++) {
            sort(arr[i], interval[i]);
            System.out.println(Arrays.toString(arr[i])
                    .replace("[","")
                    .replace("]","")
                    .replace(",",""));
        }
    }


    private static void sort(int[] arr, int[] interval){
//        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < interval.length; i++) {
            for (int j = interval[i]; j < arr.length; j++) {
                int pivot = arr[j];
                int index = j - interval[i];
                for (; index >= 0; index -= interval[i]) {
                    if(arr[index] > pivot){
                        arr[index + interval[i]] = arr[index];
                    }else {
                        break;
                    }
                }
                arr[index+interval[i]] = pivot;
            }

//            System.out.println(Arrays.toString(arr)+"===>"+interval[i]);
        }
    }
}
