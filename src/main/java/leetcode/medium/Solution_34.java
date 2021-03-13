package leetcode.medium;

public class Solution_34 {
    public int[] searchRange(int[] nums, int target) {
        return binarySearch(nums,target);
    }

    private int[] binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        int[] index = new int[2];
        index[0] = -1;
        index[1] = -1;



        while (left <= right){
            int mid = (left + right)/2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                for (int i = mid; i >= 0 && nums[i] == target; i--) {
                    index[0] = i;
                }
                for (int i = mid; i < nums.length && nums[i] == target; i++) {
                    index[1] = i;
                }
                return index;
            }

        }


        return index;
    }

}
