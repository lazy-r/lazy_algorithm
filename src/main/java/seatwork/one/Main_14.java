package seatwork.one;

import java.util.Arrays;
import java.util.Scanner;

public class Main_14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[][] arr = new int[size][];
        for (int i = 0; i < size; i++) {
            int k = in.nextInt();
            arr[i] = new int[k*k];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            Arrays.sort(arr[i]);
            System.out.println(Arrays.toString(arr[i])
                                .replace(",","")
                                .replace("[","")
                                .replace("]",""));
        }
    }
}
