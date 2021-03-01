package offer;

import org.junit.Test;

import static org.junit.Assert.*;

public class DuplicateNumber_3Test {

    @Test
    public void duplicate() {
        int[] arr = new int[1];
        int[] params = new int[]{6,3,2,0,2,5,0};
        boolean result = new DuplicateNumber_3().duplicate(params, params.length, arr);
        System.out.println(result?arr[0]+"":"无重复数字");
    }
}
