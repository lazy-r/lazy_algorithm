package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串的排列
 */
public class Solution_567 {
    public boolean checkInclusion(String s1, String s2) {
        // 存放目标字符及数量
        Map<Character, Integer> need = new HashMap<>();
        // 存放窗口内包含目标字符及数量
        Map<Character, Integer> window = new HashMap<>();

        // 初始化 need
        char[] targets = s1.toCharArray();
        for (char target : targets) {
            need.put(target, need.getOrDefault(target, 0) + 1);
        }

        // 窗口的左右边界，左闭右开[left,right)
        int left = 0;
        int right = 0;
        // 记录窗口内有效字符的数量（若某个字符有多个，则当该字符的数量满类才计作有效字符）
        int valid = 0;

        char[] src = s2.toCharArray();
        while (right < src.length) {
            // 要移入窗口的字符
            char c = src[right];
            // 窗口右移
            right++;

            // 处理窗口内的数据
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }


            // 当窗口需要收缩时
            while (valid == need.size()) {
                // 判断是否为目标字符串的排列
                int currentLenOfWindow = right - left;
                if (currentLenOfWindow == s1.length()) {
                    return true;
                }

                // 左移窗口
                char d = src[left];
                left++;

                // 处理窗口内数据
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }

            }

        }

        return false;
    }

}
