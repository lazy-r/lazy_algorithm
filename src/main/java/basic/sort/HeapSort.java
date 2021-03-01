package basic.sort;

import java.util.Arrays;

public class HeapSort implements MySort{
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            // 1、进行大顶堆调整
            heapAdjust(arr, arr.length - 1 - i);
            // 2、将大顶堆的最大值放到该放的位置
            swap(arr, 0, arr.length - i -1);
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private void heapAdjust(int[] arr, int end) {
        // 1、找到第一个非叶子节点
        int parentIndex = (end - 1)/2;

        for (int i = parentIndex; i >= 0; i--) {
            // 2、若有右子节点，则判断左右节点大小，将较大数的换入左节点
            if(i*2 + 2 <= end&&arr[i*2 + 1] < arr[i*2 + 2]){
                swap(arr, i*2 + 1, i*2 + 2);
            }

            // 3、判断父节点和左子节点的大小，将较大的换入父节点
            if(arr[i] < arr[i*2 + 1]){
                swap(arr, i, i*2 + 1);
            }
        }
    }



    @Override
    public void optimizedSort(int[] arr) {

    }
}
