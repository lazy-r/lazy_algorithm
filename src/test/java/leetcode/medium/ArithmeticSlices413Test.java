package leetcode.medium;

import leetcode.dynamic_programming.medium.ArithmeticSlices_413;
import org.junit.Test;

public class ArithmeticSlices413Test {

    @Test
    public void numberOfArithmeticSlices() {
        int[] arr = new int[]{1,2,3,8,9,10};
        System.out.println(new ArithmeticSlices_413().numberOfArithmeticSlices(arr));
    }
}
