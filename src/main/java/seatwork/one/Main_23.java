package seatwork.one;

import java.util.Arrays;
import java.util.Scanner;

public class Main_23 {
    private static int num = 1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        in.nextLine();
        int[] n = new int[size];
        int[][] specialPosition = new int[size][2];
        int[][] LPosition = new int[size][2];
        for (int i = 0; i < size; i++) {
            n[i] = in.nextInt();
            specialPosition[i][0] = in.nextInt();
            specialPosition[i][1] = in.nextInt();
            LPosition[i][0] = in.nextInt();
            LPosition[i][1] = in.nextInt();
        }

        for (int i = 0; i < size; i++) {
            calculate(n[i], specialPosition[i], LPosition[i]);
        }

    }

    private static void calculate(int n, int[] specialPosition, int[] LPosition) {
        int[][] matrix = new int[(int) Math.pow(2,n)][(int) Math.pow(2,n)];
        fillMatrix(matrix, 0, 0, n, specialPosition);
//        for (int i = 0; i < matrix.length; i++) {
//            System.out.println(Arrays.toString(matrix[i]));
//        }
        findLPosition(matrix, LPosition);
//        System.out.println("============================");

    }

    private static void findLPosition(int[][] matrix, int[] LPosition) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == matrix[LPosition[0]][LPosition[1]]){
//                    System.out.println(i+" "+j+"=>"+matrix[i][j]);
                    if(i == LPosition[0]&&j == LPosition[1]){

                    }else {
                        buffer.append(i+" "+j+",");
                    }
                }
            }
        }
        System.out.println(buffer.toString().substring(0,buffer.length()-1));

    }

    private static void fillMatrix(int[][] matrix, int left, int up, int n, int[] specialPosition) {
//        System.out.println("matrix = " + Arrays.deepToString(matrix) + ", left = " + left + ", up = " + up + ", n = " + n + ", specialPosition = " + Arrays.toString(specialPosition));

        int x = specialPosition[0];
        int y = specialPosition[1];
        int right = left + 1;
        int down = up + 1;
        if(n == 1){
            if(left != x||up != y){
                matrix[left][up] = num;
            }
            if(left != x||down != y){
                matrix[left][down] = num;

            }
            if (right != x||up != y){
                matrix[right][up] = num;

            }
            if (right != x||down != y){
                matrix[right][down] = num;
            }
            num++;
            return;
        }

        int levelMid = left + (int)Math.pow(2, n-1);
        int verticalMid = up + (int)Math.pow(2, n-1);

        if(x < levelMid && y < verticalMid){
            // 特殊点在左上角

            matrix[levelMid-1][verticalMid] = num;
            matrix[levelMid][verticalMid-1] = num;
            matrix[levelMid][verticalMid] = num;
            num++;



            // 填充左上角
            fillMatrix(matrix, left, up, n-1, specialPosition);
            // 填充左下角
            fillMatrix(matrix, left, verticalMid, n-1, new int[]{levelMid-1, verticalMid});
            // 填充右上角
            fillMatrix(matrix, levelMid, up, n-1, new int[]{levelMid, verticalMid-1});
            // 填充右下角
            fillMatrix(matrix, levelMid, verticalMid, n-1, new int[]{levelMid, verticalMid});



        }else if(x < levelMid && y >= verticalMid){
            // 特殊点在左下角

            matrix[levelMid-1][verticalMid-1] = num;
            matrix[levelMid-1][verticalMid] = num;
            matrix[levelMid][verticalMid] = num;
            num++;

            // 填充左上角
            fillMatrix(matrix, left, up, n-1, new int[]{levelMid-1, verticalMid-1});
            // 填充左下角
            fillMatrix(matrix, left, verticalMid, n-1, specialPosition);
            // 填充右上角
            fillMatrix(matrix, levelMid, up, n-1, new int[]{levelMid, verticalMid-1});
            // 填充右下角
            fillMatrix(matrix, levelMid, verticalMid, n-1, new int[]{levelMid, verticalMid});

        }else if(x >= levelMid && y >= verticalMid){
            // 特殊点在右下角

            matrix[levelMid-1][verticalMid-1] = num;
            matrix[levelMid][verticalMid-1] = num;
            matrix[levelMid-1][verticalMid] = num;
            num++;

            // 填充左上角
            fillMatrix(matrix, left, up, n-1, new int[]{levelMid-1, verticalMid-1});
            // 填充左下角
            fillMatrix(matrix, left, verticalMid, n-1, new int[]{levelMid-1, verticalMid});
            // 填充右上角
            fillMatrix(matrix, levelMid, up, n-1, new int[]{levelMid, verticalMid-1});
            // 填充右下角
            fillMatrix(matrix, levelMid, verticalMid, n-1, specialPosition);

        }else if(x >= levelMid && y < verticalMid){
            //  特殊点在右上角

            matrix[levelMid-1][verticalMid-1] = num;
            matrix[levelMid - 1][verticalMid] = num;
            matrix[levelMid][verticalMid] = num;
            num++;

            // 填充左上角
            fillMatrix(matrix, left, up, n-1, new int[]{levelMid-1, verticalMid-1});
            // 填充左下角
            fillMatrix(matrix, left, verticalMid, n-1, new int[]{levelMid - 1, verticalMid});
            // 填充右上角
            fillMatrix(matrix, levelMid, up, n-1, specialPosition);
            // 填充右下角
            fillMatrix(matrix, levelMid, verticalMid, n-1, new int[]{levelMid, verticalMid});

        }

    }
}
