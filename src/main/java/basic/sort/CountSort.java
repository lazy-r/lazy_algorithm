package basic.sort;

public class CountSort implements MySort{
    @Override
    public void sort(int[] arr) {
        if(arr.length <= 0){
            return;
        }
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = arr[i] > max?arr[i]:max;
            min = arr[i] < min?arr[i]:min;
        }
        int[] bucket = new int[max + 1 -min];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i] - min]++;
        }

        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0){
                arr[index++] = i + min;
            }
        }
    }

    @Override
    public void optimizedSort(int[] arr) {

    }
}
