package seatwork.one;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_6 {
    public static void main(String[] args) {



        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            String num = in.next();
            result[i] = calculate(new BigInteger(num));
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int calculate(BigInteger P) {
        int count = 0;
        BigInteger people = new BigInteger("1");
        BigInteger zero = new BigInteger("0");

        while ((P = P.subtract(people.pow(2))).compareTo(zero) >= 0){
            people = people.add(BigInteger.ONE);
            count++;
        }
        return count;
    }
}
