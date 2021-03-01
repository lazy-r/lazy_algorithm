package basic.search;

public class InterpolationSearch extends MySearch{
    @Override
    public int search(int[] arr, int findVal) {
        if(findVal < arr[0]||findVal > arr[arr.length - 1]){
            return  -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right){
            if(arr[left] == arr[right]){
                return arr[left] == findVal?left:-1;
            }
            int current = left + (right - left)*((findVal - arr[left])/(arr[right] - arr[left]));
            if(arr[current] > findVal){
                right = current - 1;
            }else if(arr[current] < findVal){
                left = current + 1;
            }else {
                return current;
            }
        }
        return -1;
    }

    @Override
    public int optimizedSearch(int[] arr, int findVal) {
        return 0;
    }
}
