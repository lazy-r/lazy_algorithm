package seatwork.one;

import java.util.Arrays;
import java.util.Scanner;

public class Main_13 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[][] arr = new int[size][];
        int[] Ks = new int[size];
        for (int i = 0; i < size; i++) {
            int N = in.nextInt();
            int K = in.nextInt();
            arr[i] = new int[N];
            Ks[i] = K;
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < arr.length; i++) {
            calculate(arr[i], Ks[i]);
            System.out.println();
        }

    }

    private static void calculate(int[] arr, int K) {
        Arrays.sort(arr);
        violentSolution(arr, K, 0, 4, new int[4]);
    }

    private static void violentSolution(int[] arr, int K, int startIndex, int size, int[] result) {
        if(size == 1){
            for (int i = startIndex; i < arr.length; i++) {

                if(arr[i] == K){
                    result[4 - size] = arr[i];
                    for (int j = 0; j < result.length; j++) {
                        System.out.print(result[j]+" ");
                    }
                    System.out.print("$");
                    return;
                }
            }
            return;
        }


        for (int i = startIndex; i < arr.length; i++) {
            if(i > startIndex&&arr[i] == arr[i-1]){
            }else{
                result[4 - size] = arr[i];
                violentSolution(arr, K-arr[i], i+1, size-1, result);
            }
        }


    }




}
