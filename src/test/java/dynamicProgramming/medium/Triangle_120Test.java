package dynamicProgramming.medium;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Triangle_120Test {

    @org.junit.Test
    public void minimumTotal() {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row0 = new ArrayList<>();
        row0.add(2);
        List<Integer> row1 = new ArrayList<>();
        row1.add(3);
        row1.add(4);
        List<Integer> row2 = new ArrayList<>();
        row2.add(6);
        row2.add(5);
        row2.add(7);
        List<Integer> row3 = new ArrayList<>();
        row3.add(4);
        row3.add(1);
        row3.add(8);
        row3.add(3);
        triangle.add(row0);
        triangle.add(row1);
        triangle.add(row2);
        triangle.add(row3);
        System.out.println(new Triangle_120().minimumTotal(triangle));
    }
}
