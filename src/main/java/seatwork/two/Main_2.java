package seatwork.two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_2 {
    class Node {
        String name;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        for (int i = 0; i < size; i++) {
            int nodeNum = in.nextInt();
            String startNode = in.next();

            Map<String, Integer> nodeMap = new HashMap<>();

            for (int j = 0; j < nodeNum; j++) {
                nodeMap.put(in.next(), j);
            }

            int[][] graph = new int[nodeNum][nodeNum];
            for (int row = 0; row < nodeNum; row++) {
                int index = nodeMap.get(in.next());
                for (int col = 0; col < nodeNum; col++) {
                    graph[index][col] = in.nextInt();
                }
            }
            System.out.println(Arrays.deepToString(graph));
        }

    }
}
