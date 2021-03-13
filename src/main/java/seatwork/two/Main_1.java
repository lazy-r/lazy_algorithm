package seatwork.two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        // 初始化字母表，将字母转换为对应的数字顺序
        char c = 'a';
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char)(c+i), i);
        }

        int[][] graph = new int[26][26];


        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        in.nextLine();
        for (int i = 0; i < size; i++) {
            String str = in.nextLine();
            String[] edges = str.split(",");
            System.out.println(Arrays.toString(edges));
            for (int j = 0; j < edges.length; j++) {
                char[] nodes = edges[j].toCharArray();
                graph[map.get(nodes[0])][map.get(nodes[1])] = 1;
            }
        }



    }
}
