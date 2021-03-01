package basic.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciSearch extends MySearch{




    @Override
    public int search(int[] arr, int findVal) {

        // 1、初始化斐波那契数组
        int[] fibonacciArr = createFibonacciArr(arr.length);
        // 2、初始化斐波那契数组的下标（大于等于原数组长度第一个斐波那契数的下标）
        int fibonacciIndex = 0;
        while (fibonacciArr[fibonacciIndex] < arr.length){
            fibonacciIndex++;
        }
        // 3、将原始数组扩容为长度（大于等于原数组长度第一个斐波那契数的下标）
        int[] expandedArr = new int[fibonacciArr[fibonacciIndex]];
        for (int i = 0; i < expandedArr.length; i++) {
            expandedArr[i] = i < arr.length?arr[i]:arr[arr.length-1];
        }

        // 4、初始化左右边界
        int left = 0;
        int right = arr.length - 1;

        // 5、进行查找
        while (left <= right){
            int mid = left + fibonacciArr[fibonacciIndex - 1] - 1;
            if(expandedArr[mid] > findVal){
                right = mid - 1;
                fibonacciIndex--;
            }else if(expandedArr[mid] < findVal){
                left = mid + 1;
                fibonacciIndex--;
            }else {
                return mid < arr.length?mid:arr.length-1;
            }

        }

        return -1;
    }

    @Override
    public int optimizedSearch(int[] arr, int findVal) {
        return 0;
    }

    public int[] createFibonacciArr(int len) {
        int[] fibonacciArr = new int[len];
        if(len > 0){
            fibonacciArr[0] = 1;
        }
        if(len > 1){
            fibonacciArr[1] = 1;
        }
        for (int i = 2; i < len; i++) {
            fibonacciArr[i] = fibonacciArr[i-1] + fibonacciArr[i-2];
        }
        return fibonacciArr;
    }
}
