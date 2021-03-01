package basic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BucketSort implements MySort{
    @Override
    public void sort(int[] arr) {
        if(arr.length <= 0){
            return;
        }
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = arr[i] > max?arr[i]:max;
            min = arr[i] < min?arr[i]:min;
        }

        List<Integer>[] buckets = new ArrayList[10];
        int divisor = (int) Math.pow(10,(int)Math.log10(max));
//        System.out.println("divisor = "+divisor);
        for (int i = 0; i < arr.length; i++) {
            List<Integer> bucket = null;
            if(buckets[arr[i]/divisor] == null){
                bucket = new ArrayList<>();
            }else {
                bucket = buckets[arr[i]/divisor];
            }
            bucket.add(arr[i]);
            buckets[arr[i]/divisor] = bucket;
//            System.out.println("index = "+(arr[i]/divisor)+", bucket = "+bucket.toString());

        }

        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            if(buckets[i] != null){
                List<Integer> bucket = buckets[i];
                bucket.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1-o2;
                    }
                });
                for (int j = 0; j < bucket.size(); j++) {
                    arr[index++] = bucket.get(j);
                }
            }
        }


    }

    @Override
    public void optimizedSort(int[] arr) {

    }
}
