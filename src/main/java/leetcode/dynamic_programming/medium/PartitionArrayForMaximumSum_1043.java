package leetcode.dynamic_programming.medium;

public class PartitionArrayForMaximumSum_1043 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // 保存结果
        int[] result = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            // 用来记录不同划分组合中的最大值
            int tempMax = arr[i];
            // 计算不同划分组合的最大和
            for (int j = 1; j <= k&&i-j+1>=0; j++) {
                tempMax = tempMax>arr[i-j+1]?tempMax:arr[i-j+1];
                result[i+1] = result[i+1]>result[i+1-j]+tempMax*j?result[i+1]:result[i+1-j]+tempMax*j;
            }
        }

        return result[arr.length];
    }
}
