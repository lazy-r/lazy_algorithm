package basic.sort;

import java.util.Arrays;

public class QuickSort implements MySort{
    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length-1);
    }
    private void sort(int[] arr, int left, int right){
        // 1、当只有一个元素的时候，停止排序
        if(left >= right){
            return;
        }

        // 2、确定枢纽
        int pivot = arr[left];
        int leftIndex = left;
        int rightIndex = right;


        while(leftIndex < rightIndex){
            // 3、找到右边一个比枢纽小的数
            while (arr[rightIndex] > pivot && leftIndex < rightIndex){
                rightIndex--;
            }
            // 4、将比枢纽小的数放到左边
            arr[leftIndex] = arr[rightIndex];

            // 5、找到左边一个比枢纽的大的数
            while(arr[leftIndex] < pivot&&leftIndex < rightIndex){
                leftIndex++;
            }
            // 6、将比枢纽大的数放到右边
            arr[rightIndex--] = arr[leftIndex];
        }

        // 7、将枢纽放到该放的位置
        arr[leftIndex] = pivot;
        // 8、以枢纽该在的位置为分界线，继续处理数组
        sort(arr, left,leftIndex-1);
        sort(arr,leftIndex+1, right);

    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    @Override
    public void optimizedSort(int[] arr) {

    }
}
