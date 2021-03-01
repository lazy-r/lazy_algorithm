package seatwork.one;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();

        int[][] ABC = new int[size][3];

        for (int i = 0; i < size; i++) {
            ABC[i][0] = in.nextInt();
            ABC[i][1] = in.nextInt();
            ABC[i][2] = in.nextInt();
        }

        calculate(ABC);

    }

    private static void calculate(int[][] ABC) {
        for (int i = 0; i < ABC.length; i++) {
            BigInteger baseNumber = new BigInteger(ABC[i][0]+"");
            BigInteger pow = baseNumber.pow(ABC[i][1]);
            BigInteger result = pow.mod(new BigInteger(ABC[i][2] + ""));
            System.out.println(result);
        }

    }

}
