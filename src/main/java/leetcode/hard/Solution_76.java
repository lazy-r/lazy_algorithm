package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 最小覆盖子串
 */
public class Solution_76 {
    public String minWindow(String s, String t) {
        // 记录还需要的目标字符及数量
        Map<Character, Integer> needs = new HashMap<>();
        // 记录窗口内包含的目标字符及数量
        Map<Character, Integer> windows = new HashMap<>();

        // 初始化needs
        char[] targets = t.toCharArray();
        for (char target : targets) {
            needs.put(target, needs.getOrDefault(target, 0) + 1);
        }

        // 窗口的左右边界，左闭右闭[left,right]
        int left = 0;
        int right = 0;
        // 记录窗口中有效的字符（若某个字符有多个，则当该字符的数量满类才计作有效字符）
        int valid = 0;

        // 记录最小包含字符串的左边界
        int start = 0;
        // 记录最小包含字符串的长度
        int len = Integer.MAX_VALUE;

        char[] src = s.toCharArray();
        while (right < src.length) {
            // c 是将要移入窗口的字符
            char c = src[right];
            // 右移窗口
            right++;

            // 进行窗口内数据的一系列更新
            if (needs.containsKey(c)) {
                // 更新 windows 内 c 字符的个数
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                // 若此时 windows 中 c 字符的数量和 needs 中 c 字符的数量相等，则有效字符个数加一
                if (windows.get(c).equals(needs.get(c))) {
                    valid++;
                }

            }

            // ...

            //System.out.println("left = "+left+", right = "+right);


            // 判断左侧串口是否要收缩（当窗口内有效字符的数量和 needs 中的字符数量一致时，需要收缩）
            while (valid == needs.size()) {
                // 当需要收缩时，更新最小字符串的数据（取收缩到极致时的数据）
                int currentLenOfWindows = right - left;
                if (currentLenOfWindows < len) {
                    len = currentLenOfWindows;
                    start = left;
                }

                // d 是将要移出窗口的字符
                char d = src[left];
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                // 更新 windows 内 d 字符的个数
                if (needs.containsKey(d)) {
                    // 若此时 windows 中 d 字符的数量小于 needs 中 d 字符的数量，则有效字符减一
                    if (windows.get(d).equals(needs.get(d))) {
                        valid--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }





            }

        }

        return len == Integer.MAX_VALUE ? "" : new String(src, start, len);
    }

}
