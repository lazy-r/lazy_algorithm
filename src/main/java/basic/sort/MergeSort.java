package basic.sort;

import java.util.Arrays;

public class MergeSort implements MySort{


    @Override
    public void sort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr,0,arr.length-1,temp);
    }

    private void sort(int[] arr, int left, int right, int[] temp) {
        // 1、若数组划分到只有一个元素
        if(left >= right){
            return;
        }

        // 2、将左右部分进行排序
        int mid = (left + right)/2;
        sort(arr, left, mid, temp);
        sort(arr, mid+1, right, temp);

        // 3、将排好序的左右部分进行排序
        merge(arr, left, right, temp);

    }

    private void merge(int[] arr, int left, int right, int[] temp) {
        int mid = (left + right)/2;
        int leftIndex = left;
        int rightIndex = mid + 1;
        int tempIndex = left;

        while(leftIndex <= mid&&rightIndex <= right){
            if(arr[leftIndex] <= arr[rightIndex]){
                temp[tempIndex++] = arr[leftIndex++];
            }else {
                temp[tempIndex++] = arr[rightIndex++];
            }
        }

        while(leftIndex <= mid){
            temp[tempIndex++] = arr[leftIndex++];
        }
        while(rightIndex <= right){
            temp[tempIndex++] = arr[rightIndex++];
        }
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

    }


    public void optimizedSort(int[] arr){
        optimizedSort(arr, 0, arr.length-1, new int[arr.length]);
    }

    private void optimizedSort(int[] arr, int left, int right, int[] temp){
        if(left >= right){
            return;
        }
        int mid = (left + right)/2;
        optimizedSort(arr, left, mid, temp);
        optimizedSort(arr, mid+1, right, temp);

        optimizedMerge(arr, left, mid, right, temp);



    }

    private void optimizedMerge(int[] arr, int left, int mid, int right, int[] temp) {
        int leftBegin = left;
        int rightBegin = mid+1;
        if(arr[mid] <= arr[rightBegin]){
            return;
        }
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int begin = left;
        while (begin <= right){
            if(leftBegin <= mid&&rightBegin <= right){
                arr[begin++] = temp[leftBegin]<temp[rightBegin]?temp[leftBegin++]:temp[rightBegin++];
            }else {
                arr[begin++] = leftBegin<=mid?temp[leftBegin++]:temp[rightBegin++];
            }
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
