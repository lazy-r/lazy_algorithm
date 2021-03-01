package seatwork.one;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Main_9Test {

    @Test
    public void test(){
        String[][] map = new String[101][101];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = " ";
            }
        }

        String str = "-39 15 -43 24 -34 -23 48 33 -9 49 -14 -44 -37 -33 -20 -1 -9 2 10 20 46 6 -11 -42 -41 7 38 -36";
        int[][] arr = toArr(str);
        for (int i = 0; i < arr.length; i++) {
            map[arr[i][1]+50][arr[i][0]+50] = "*";
        }

        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }

    private int[][] toArr(String str) {
        String[] s = str.split(" ");
        int[][] arr = new int[s.length/2][2];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = Integer.parseInt(s[index++]);
            arr[i][1] = Integer.parseInt(s[index++]);
        }
        return arr;
    }
}
