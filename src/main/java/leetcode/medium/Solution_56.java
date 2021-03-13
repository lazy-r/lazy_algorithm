package leetcode.medium;


import java.util.ArrayList;
import java.util.List;

public class Solution_56 {
    public int[][] merge(int[][] intervals) {
        // 将数组按一维坐标升序排序
        sort(intervals, 0, intervals.length-1, 0);

        List<int[]> list = new ArrayList<int[]>();
        int[] interval = intervals[0];
        list.add(interval);

        for (int i = 1; i < intervals.length; i++) {
            interval = list.get(list.size()-1);
            if(interval[1] >= intervals[i][0]){
                interval[1] = interval[1]>intervals[i][1]?interval[1]:intervals[i][1];
            }else {
                list.add(intervals[i]);
            }
        }
        int[][] result = new int[list.size()][2];
        list.toArray(result);
        return result;
    }

    private static void sort(int[][] arr, int left, int right, int dimension){
        if(left >= right){
            return;
        }

        int leftIndex = left;
        int rightIndex = right;
        int[] pivot = arr[left];

        while (leftIndex < rightIndex){
            while (arr[rightIndex][dimension] > pivot[dimension] && leftIndex < rightIndex){
                rightIndex--;
            }
            arr[leftIndex] = arr[rightIndex];
            while (arr[leftIndex][dimension] < pivot[dimension]&& leftIndex < rightIndex){
                leftIndex++;
            }
            arr[rightIndex--] = arr[leftIndex];
        }
        arr[leftIndex] = pivot;

        sort(arr, left, leftIndex-1, dimension);
        sort(arr, leftIndex+1, right, dimension);

    }
}
