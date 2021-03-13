package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Solution_51 {
    private static List<List<String>> result = new ArrayList<>();


    public List<List<String>> solveNQueens(int n) {
        if(n == 1){
            List<String> list = new ArrayList<>();
            list.add("Q");
            result.add(list);
            return result;
        }


        int[][] checkerboard = new int[n][n];
        int[] cols = new int[n];
        List<String> temp = new ArrayList<>();


        for (int col = 0; col < n; col++) {
            checkerboard[0][col] = 1;
            cols[col] = 1;
            temp.add(generateStr(n, col));

            hasNext(temp, checkerboard, 1, cols);

            temp.remove(temp.size() - 1);
            checkerboard[0][col] = 0;
            cols[col] = 0;

        }


        return result;
    }

    private void hasNext(List<String> temp, int[][] checkerboard, int raw, int[] cols) {
        // 递归到最后一行终止
        if(raw == checkerboard.length - 1){
            for (int col = 0; col < cols.length; col++) {
                if(cols[col] != 1){
                    boolean isValid = isValid(checkerboard, raw, col);
                    if(isValid){
                        List<String> list = new ArrayList<>();
                        for (int i = 0; i < temp.size(); i++) {
                            list.add(temp.get(i));
                        }
                        list.add(generateStr(cols.length, col));

                        result.add(list);
                    }

                }
            }
            return;
        }

        for (int col = 0; col < cols.length; col++) {
            if(cols[col] != 1 && isValid(checkerboard, raw, col)){
                cols[col] = 1;
                checkerboard[raw][col] = 1;
                temp.add(generateStr(cols.length, col));

                hasNext(temp, checkerboard, raw+1, cols);

                temp.remove(temp.size()-1);
                cols[col] = 0;
                checkerboard[raw][col] = 0;
            }
        }



    }

    private String generateStr(int n, int col) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            buffer.append(col == i?"Q":".");
        }
        return buffer.toString();
    }

    private boolean isValid(int[][] checkerboard, int raw, int col) {
        // 检查列是否冲突
        for (int i = raw; i >= 0; i--) {
            if(checkerboard[i][col] == 1){
                return false;
            }
        }
        // 检查左上对角线是否冲突
        for (int i = 1; raw - i >= 0 && col - i >= 0; i++) {
            if(checkerboard[raw-i][col-i] == 1){
                return false;
            }
        }


        // 检查右上对角线是否冲突
        for (int i = 1; raw - i >= 0 && col + i < checkerboard.length; i++) {
            if(checkerboard[raw-i][col+i] == 1){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_51().solveNQueens(1));
    }
}
