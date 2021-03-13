package leetcode.simple;

import java.util.Arrays;

public class Solution_1 {

    public int[] twoSum(int[] nums, int target) {
        // 保留数组的原始序号在二维里
        int[][] specialNums = transform(nums);
        sort(specialNums, 0, specialNums.length - 1);

        int left = 0;
        int right = specialNums.length - 1;

        while (left <= right) {
            int sum = specialNums[left][0] + specialNums[right][0];

            if (sum == target) {
                return new int[]{specialNums[left][1], specialNums[right][1]};
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }
        return new int[]{-1, -1};

    }

    private void sort(int[][] arr, int  left, int right) {


        if (left >= right) {
            return;
        }

        int leftIndex = left;
        int rightIndex = right;
        int[] pivot = arr[left];

        while (leftIndex < rightIndex) {
            while (arr[rightIndex][0] > pivot[0] && leftIndex < rightIndex) {
                rightIndex--;
            }
            arr[leftIndex] = arr[rightIndex];

            while (arr[leftIndex][0] < pivot[0] && leftIndex < rightIndex) {
                leftIndex++;
            }
            arr[rightIndex--] = arr[leftIndex];
        }

        arr[leftIndex] = pivot;
        sort(arr, left, leftIndex - 1);
        sort(arr, leftIndex + 1, right);
    }

    private int[][] transform(int[] nums) {
        int[][] specialNums = new int[nums.length][2];
        for (int i = 0; i < specialNums.length; i++) {
            specialNums[i][0] = nums[i];
            specialNums[i][1] = i;
        }
        return specialNums;
    }

}
