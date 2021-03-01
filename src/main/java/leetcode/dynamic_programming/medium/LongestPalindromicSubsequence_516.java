package leetcode.dynamic_programming.medium;

import java.util.Arrays;

public class LongestPalindromicSubsequence_516 {
    public int longestPalindromeSubseq(String s) {
        if(s.length() == 1){
            return 1;
        }
        int[] result = new int[s.length()];
        char[] chars = s.toCharArray();
        // 初始化
        result[0] = 1;
        result[1] = chars[1] == chars[0]?2:1;
        for (int i = 2; i < result.length; i++) {
            int firstEqualIndex = 0;
            for (; firstEqualIndex < i; firstEqualIndex++) {
                if(chars[firstEqualIndex] == chars[i]){
                    break;
                }
            }
            int max = 0;
            int addCount = 1;
            for (int j = firstEqualIndex; j < i; j++) {
                max = result[j]>max?result[j]:max;
                addCount = addCount==1?chars[i] == chars[j]?1:2:2;
            }
            System.out.println(s);
            System.out.println("i=>"+i+",firstEqualIndex=>"+firstEqualIndex);
            System.out.println("max=>"+max+",addCount = "+addCount);
            result[i] = max - result[firstEqualIndex] + addCount;
            System.out.println(Arrays.toString(result));
            System.out.println("-------------------");
        }

        return result[s.length()-1];
    }
}
