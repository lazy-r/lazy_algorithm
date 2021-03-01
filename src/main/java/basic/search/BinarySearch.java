package basic.search;

import java.util.Arrays;

public class BinarySearch extends MySearch{
    @Override
    public int search(int[] arr, int findVal) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right){
            int mid = (left + right)/2;
            if(arr[mid] == findVal){
                return mid;
            }else if(arr[mid] > findVal){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return -1;
    }

    @Override
    public int optimizedSearch(int[] arr, int findVal) {
        return 0;
    }
}
