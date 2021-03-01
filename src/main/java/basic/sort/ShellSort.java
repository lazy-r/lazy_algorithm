package basic.sort;

import java.util.Arrays;

public class ShellSort implements MySort{
    @Override
    public void sort(int[] arr) {
        for (int i = arr.length/2; i > 0; i /= 2) {
            for (int j = i; j < arr.length; j++) {
                for (int k = j; k >= i; k -= i) {
                    if(arr[k] < arr[k - i]){
                        swap(arr, k, k-i);
                    }else {
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void optimizedSort(int[] arr) {

    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
