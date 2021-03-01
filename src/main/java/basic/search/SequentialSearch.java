package basic.search;

public class SequentialSearch extends MySearch{
    @Override
    public int search(int[] arr, int findVal) {
        for (int i = 0; i < arr.length; i++) {
            if(findVal == arr[i]){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int optimizedSearch(int[] arr, int findVal) {
        return 0;
    }
}
