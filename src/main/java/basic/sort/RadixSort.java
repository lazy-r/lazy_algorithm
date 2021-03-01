package basic.sort;

import java.util.ArrayList;
import java.util.List;

public class RadixSort implements MySort{
    @Override
    public void sort(int[] arr) {
        if(arr.length <= 0){
            return;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = max > arr[i]?max:arr[i];
        }

        int power = (int)Math.log10(max);

        for (int i = 0; i <= power; i++) {
            List<Integer>[] buckets = new ArrayList[10];
            int divisor = (int)Math.pow(10,i);
            for (int j = 0; j < arr.length; j++) {
                List<Integer> bucket = null;
                if(buckets[arr[j]/divisor%10] == null){
                    bucket = new ArrayList<>();
                    buckets[arr[j]/divisor%10] = bucket;
                }else {
                    bucket = buckets[arr[j]/divisor%10];
                }
                bucket.add(arr[j]);
            }
            int index = 0;
            for (int j = 0; j < buckets.length; j++) {
                if(buckets[j] != null){
                    for (int k = 0; k < buckets[j].size(); k++) {
                        arr[index++] = buckets[j].get(k);
                    }
                }
            }
        }
    }

    @Override
    public void optimizedSort(int[] arr) {

    }
}
