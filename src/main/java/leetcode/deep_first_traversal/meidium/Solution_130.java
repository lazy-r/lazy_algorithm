package leetcode.deep_first_traversal.meidium;

import java.util.Arrays;

public class Solution_130 {
    public void solve(char[][] board) {
        int[][] flag = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                flag[i][j] = board[i][j] == 'X'?1:0;
            }
        }



        // 将边界上的O点进行dfs
        // 将第一行和最后一行不为X的点dfs
        for (int i = 0; i < board[0].length; i++) {
            if(flag[0][i] != 1){
                dfs(flag, i,0);
            }
            if(flag[flag.length-1][i] != 1){
                dfs(flag, i, board.length-1);
            }
        }

        // 将
        for (int i = 0; i < board.length; i++) {
            if(flag[i][0] != 1){
                dfs(flag,  0,i);
            }
            if(flag[i][flag[0].length-1] != 1){
                dfs(flag, board[0].length-1, i);
            }
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = flag[i][j] == 0?'X':board[i][j];
            }
            System.out.println(Arrays.toString(flag[i]));
        }

    }

    private void dfs(int[][] flag, int x, int y){

        if(flag[y][x] == 1){
            return;
        }
        System.out.println(x+","+y+" = "+flag[y][x]);
        flag[y][x] = 1;
        if (x - 1 >= 0){
            dfs(flag, x-1, y);
        }

        if(y-1 >= 0){
            dfs(flag, x, y-1);
        }

        if(x + 1 < flag[0].length){
            dfs(flag, x+1, y);
        }

        if(y + 1 < flag.length){
            dfs(flag, x, y+1);
        }
    }


    public static void main(String[] args) {

    }

}
