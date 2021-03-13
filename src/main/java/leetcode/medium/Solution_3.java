package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 无重复字符的最长子串
 */
public class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;

        int len = 0;
        char[] src = s.toCharArray();
        while (right < src.length) {
            // 待移入窗口的字符
            char c = src[right];
            right++;


            // 处理窗口内数据
            window.put(c, window.getOrDefault(c, 0) + 1);

            // 收缩窗口
            while (window.get(c) > 1) {
                char d = src[left];
                left++;

                // 将移出窗口的字符个数减一
                window.put(d, window.get(d) - 1);
            }

            // 处理最长子串长度
            len = right - left > len ? right - left : len;


        }
        return len;

    }

}
