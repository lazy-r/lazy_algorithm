package dynamicProgramming.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 初始化数组，使用minimumRows来记录最短路径
        int[][] minimumRows = new int[2][triangle.size()];
        int init = (triangle.size()-1)%2;
        // 底行的最佳路径为本身数值
        List<Integer> lastRow = triangle.get(minimumRows[0].length-1);
        for (int i = 0; i < minimumRows[init].length; i++) {
            minimumRows[init][i] = lastRow.get(i);
        }

        int currentIdx = init;
        int rearIdx = init;
        for (int i = triangle.size()-2; i >= 0; i--) {
            // 保存每行的最短路径
            currentIdx = i%2;
            int[] currentMinimumRow = minimumRows[currentIdx];
            // 获取下一行最短路径，方便进行比较
            rearIdx = (i+1)%2;
            int[] rearMinimumRow = minimumRows[rearIdx];
            // 获取当前行的数值，方便进行比较
            List<Integer> currentRow = triangle.get(i);
            // 获取当前行的列数
            int colSize = currentRow.size();
            for (int j = 0; j < colSize; j++) {
                currentMinimumRow[j] = currentRow.get(j) + min(rearMinimumRow[j],rearMinimumRow[j+1]);
            }
        }

        return minimumRows[0][0];

    }
    public int min(int a, int b){
        return a<b?a:b;
    }
}
