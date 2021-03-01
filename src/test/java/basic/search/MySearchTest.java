package basic.search;

import org.junit.Test;

import static org.junit.Assert.*;

public class MySearchTest {

    @Test
    public void test() {
        int size = 150;
        for (int i = 0; i < size; i++) {
//        new SequentialSearch().test(false);
//        new BinarySearch().test(true);
//        new FibonacciSearch().test(true);
            new InterpolationSearch().test(true);
        }
    }
}
