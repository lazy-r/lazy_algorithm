package seatwork.one;

import java.util.Arrays;
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
public class Main_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[][] arr = new int[size][];
        int[] ks = new int[size];
        for (int i = 0; i < size; i++) {
            ks[i] = in.nextInt();
            int n = in.nextInt();
            arr[i] = new int[n];
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }

        }
        for (int i = 0; i < size; i++) {
            System.out.println(calculate(arr[i],ks[i]));
        }
    }

    private static int calculate(int[] arr, int unit) {
        if(arr.length == 1){
            return arr[0];
        }

//        int violentResult = violentSolution(arr, unit, 0);
//        int dynamicResult = dynamicSolution(arr, unit);
//        int binaryResult = binaryResult(arr, unit);
//        System.out.println("violentResult = "+violentResult);
//        System.out.println("dynamicResult = "+dynamicResult);
//        System.out.println("binaryResult = "+binaryResult);
//        return violentSolution(arr, unit, 0);
        return dynamicSolution(arr, unit);
//        return binaryResult(arr, unit);

    }

    private static int binaryResult(int[] boards, int painter) {
        int maximumBoardLength = getMax(boards);
        int totalBoardLength = getTotal(boards);
        int[] painters = new int[totalBoardLength + 1 - maximumBoardLength];

        if(painter >= boards.length){
            return maximumBoardLength;
        }

        for (int painterIndex = 0; painterIndex < painters.length; painterIndex++) {
            int capacity = maximumBoardLength + painterIndex;
            int painterNum = 1;
            int length = 0;
            for (int boardLength = 0; boardLength < boards.length; boardLength++) {
                if(length + boards[boardLength] > capacity){
                    length = boards[boardLength];
                    painterNum++;
                }else {
                    length += boards[boardLength];
                }
            }
            painters[painterIndex] = painterNum;
        }


        int extraLength = binarySearch(painters, painter);
        return maximumBoardLength + extraLength;
    }

    private static int binarySearch(int[] buckets, int unit) {
        int left = 0;
        int right = buckets.length - 1;

        while (left <= right){
            int mid = (left + right)/2;
            if(buckets[mid] < unit){
                right = mid-1;
            }else if(buckets[mid] > unit){
                left = mid+1;
            }else {
                return getMid(buckets, mid);
            }

        }
        return -1;

    }

    private static int getMid(int[] buckets, int mid) {
        int count = buckets[mid];
        while (buckets[mid] == count){
            mid--;
        }
        return mid+1;
    }


    private static int getTotal(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        return total;
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = max>arr[i]?max:arr[i];
        }
        return max;
    }

    private static int dynamicSolution(int[] boards, int painters) {
        if(painters >= boards.length){
            return getMax(boards);
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

    /**
     * 暴力法
     * @param boards   木板数组
     * @param painters  画家数量
     * @param startIndex  数组开始的下标
     * @return
     */
    private static int violentSolution(int[] boards, int painters, int startIndex) {
        if(painters == 1){
            int boardLength = 0;
            for (int i = startIndex; i < boards.length; i++) {
                boardLength += boards[i];
            }
            return boardLength;
        }
        int currentBoardLength = 0;
        int maximumLengthOfOtherBoards = 0;
        int minimumLengthOfAllBoards = Integer.MAX_VALUE;
        int endIndex = boards.length - painters + 1;

        for (int i = startIndex; i <= endIndex; i++) {
            currentBoardLength += boards[i];
            maximumLengthOfOtherBoards = violentSolution(boards, painters-1, i+1);
            int maximumLengthOfAllPlanks = Math.max(currentBoardLength, maximumLengthOfOtherBoards);
            minimumLengthOfAllBoards = Math.min(minimumLengthOfAllBoards, maximumLengthOfAllPlanks);
        }

        return minimumLengthOfAllBoards;
    }


}
