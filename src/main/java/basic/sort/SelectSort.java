package basic.sort;

public class SelectSort implements MySort{
    @Override
    public void sort(int[] arr) {
        // 1、循环n-1次，每次找到第n-i个大的数，将其放到该放的位置
        for (int i = arr.length - 1; i > 0; i--) {
            int maxIndex = 0;
            // 2、找到本次循环最大的值
            for (int j = 1; j <= i; j++) {
                if(arr[maxIndex] < arr[j]){
                    maxIndex = j;
                }
            }
            // 3、将本次循环找到的最大的数放到该放的位置
            swap(arr, maxIndex, i);
        }
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
