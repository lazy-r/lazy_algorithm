package seatwork.one;

import java.util.Scanner;

/**
 * 描述
 *
 * 迪普雷特（Dilpreet）想要画他的狗-布佐（Buzo）的房屋，里面有n块不同长度的木板[A1，A2，...，An]。他聘请了k名画家来完成这项工作，每个画家要花1个单位的时间来涂漆1个单位的木板，问题是找到在任何画家只能涂漆连续部分的约束下完成这项工作的最短时间。登上{2，3，4}或仅登上{1}或什么都没有登上{2，4，5}。
 *
 *
 * 输入值
 *
 * 第一行包含一个整数T，即测试用例的数量。对于每个测试用例，第一行包含一个整数k，它表示绘画者的数量，而整数n表示板子的数量。下一行包含n个以空格分隔的整数，表示木板的尺寸。约束：1 <= T <= 1001 <= k <= 301 <= n <= 501 <= A [i] <= 500
 *
 *
 * 输出量
 *
 * 2
 * 2 4
 * 10 10 10 10
 * 2 4
 * 10 20 30 40
 *
 *
 * 20
 * 60
 */
public class Main_10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[][] arr = new int[size][];
        int[] ks = new int[size];
        for (int i = 0; i < size; i++) {
            int n = in.nextInt();
            arr[i] = new int[n];
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
            ks[i] = in.nextInt();

        }
        for (int i = 0; i < size; i++) {
            System.out.println(calculate(arr[i],ks[i]));
        }
    }

    private static int calculate(int[] books, int people) {
        if (books.length == 1){
            return books[0];
        }

        return dynamicSolution(books, people);
    }
    private static int dynamicSolution(int[] boards, int painters) {
        if(painters > boards.length){
            return -1;
        }


        int[][] boardsLength = new int[painters][boards.length];

        // 1、初始化
        boardsLength[0][0] = boards[0];
        for (int boardIndex = 1; boardIndex < boardsLength[0].length; boardIndex++) {
            boardsLength[0][boardIndex] = boardsLength[0][boardIndex-1] + boards[boardIndex];
        }

        for (int painterNum = 1; painterNum < painters; painterNum++) {
            for (int boardIndex = painterNum; boardIndex < boardsLength[painterNum].length; boardIndex++) {
                int currentBoardLength = 0;
                int minimumLengthOfAllBoards = Integer.MAX_VALUE;
                for (int preBoardIndex = boardIndex; preBoardIndex >= painterNum; preBoardIndex--) {
                    currentBoardLength += boards[preBoardIndex];
                    int maximumLengthOfAllPlanks = Math.max(currentBoardLength, boardsLength[painterNum-1][preBoardIndex-1]);
                    minimumLengthOfAllBoards = Math.min(minimumLengthOfAllBoards, maximumLengthOfAllPlanks);
                }
                boardsLength[painterNum][boardIndex] = minimumLengthOfAllBoards;

            }
        }


        return boardsLength[painters-1][boards.length-1];
    }

}
