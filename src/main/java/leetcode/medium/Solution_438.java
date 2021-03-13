package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 找到字符串中所有字母异位词
 */
public class Solution_438 {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();


        // 初始化 need
        char[] targets = p.toCharArray();
        for (char target : targets) {
            need.put(target, need.getOrDefault(target, 0) + 1);
        }

        // 记录窗口的左右边界，左闭右开[left, right)
        int left = 0;
        int right = 0;

        int valid = 0;

        // 记录所有起始位置
        List<Integer> starts = new ArrayList<>();

        char[] src = s.toCharArray();
        while (right < src.length) {
            // 将要移入窗口的字符
            char c = src[right];
            right++;

            // 对窗口内数据做处理
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }


            // 当窗口需要收缩时
            while (valid == need.size()) {
                // 判断是否为异位词
                int len = right - left;
                if (len == p.length()) {
                    starts.add(left);
                }

                // 对窗口内数据做处理
                char d = src[left];
                left++;

                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }

            }


        }


        return starts;

    }
}
