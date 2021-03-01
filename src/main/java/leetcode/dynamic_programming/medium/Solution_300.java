package leetcode.dynamic_programming.medium;

import java.util.Arrays;

public class Solution_300 {
    public int lengthOfLIS(int[] nums) {
        int[] result = new int[nums.length];
            result[0] = 1;

        for (int i = 1; i < result.length; i++) {
            int maxLen = 1;
            for (int j = i-1; j >= 0; j--) {
                if(nums[i] > nums[j]){
                    maxLen = maxLen > result[j] + 1?maxLen:result[j]+1;
                }
            }
            result[i] = maxLen;
        }
        System.out.println(Arrays.toString(result));
        return result[nums.length-1];

    }

    public static void main(String[] args) {
        int i = new Solution_300().lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});
        System.out.println(i);
    }
}
