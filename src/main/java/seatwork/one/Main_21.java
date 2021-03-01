package seatwork.one;

import java.util.Arrays;
import java.util.Scanner;

public class Main_21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            int len = in.nextInt();
            int[] arr = new int[len];
            for (int j = 0; j < len; j++) {
                arr[j] = in.nextInt();
            }
            result[i] = calculate(arr,0, len-1, new int[arr.length]);
            System.out.println(result[i]);
        }


    }

    private static int calculate(int[] arr, int left, int right, int[] temp) {
        if(left >= right){
            return 0;
        }
        int mid = (left + right)/2;
        int leftResult = calculate(arr, left, mid, temp);
        int rightResult = calculate(arr, mid + 1, right, temp);

        int result = merge(arr, left, right, temp);

//        System.out.println("arr = " + Arrays.toString(arr) + ", left = " + left + ", right = " + right + ", temp = " + Arrays.toString(temp));
//        System.out.println("leftResult=>"+leftResult+",rightResult=>"+rightResult+",result=>"+result+",totalResult=>"+(result+leftResult+rightResult));
        return result+leftResult+rightResult;
    }

    private static int merge(int[] arr, int left, int right, int[] temp) {
        int result = 0;

        int mid = (left + right)/2;
        int leftBegin = left;
        int rightBegin = mid+1;
        int tempBegin = left;


        while (leftBegin <= mid&&rightBegin <= right){
            if(arr[leftBegin] <= arr[rightBegin]){
                temp[tempBegin++] = arr[leftBegin++];
            }else {
                result += mid-leftBegin+1;
                temp[tempBegin++] = arr[rightBegin++];
            }
        }
        while (leftBegin <= mid){
            temp[tempBegin++] = arr[leftBegin++];
        }

        while (rightBegin <= right){
            temp[tempBegin++] = arr[rightBegin++];
        }

        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
        return result;
    }

}
