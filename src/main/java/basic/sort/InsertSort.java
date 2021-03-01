package basic.sort;

public class InsertSort implements MySort{
    @Override
    public void sort(int[] arr) {
        // 1、使所有数字放到该放的位置
        for (int i = 1; i < arr.length; i++) {
            // 2、使第i个数字放到该放的位置
            for (int j = i; j > 0; j--) {
                // 3、若当前位置比前一个位置小，则调换两个数字的位置
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                }else {
                    break;
                }
            }
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
