package leetcode.dynamic_programming.medium;

public class ArithmeticSlices_413 {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3){
            return 0;
        }
        int[] result = new int[A.length];

        // 初始化
        int num = A[1] - A[0];
        result[2] = (A[2] - A[1]) == num?1:0;
        for (int i = 3; i < A.length; i++) {
            num = A[i] - A[i-1];
            for (int j = 1; j < i; j++) {
                if((A[i-j] - A[i-j-1]) == num){
                    result[i]++;
                }else {
                    break;
                }
            }

            result[i] = result[i] + result[i-1];
        }

        return result[A.length-1];
    }
}
