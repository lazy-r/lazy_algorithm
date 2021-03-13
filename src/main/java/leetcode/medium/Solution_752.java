package leetcode.medium;

import java.util.*;

/**
 * 打开转盘锁
 */

public class Solution_752 {
    public int openLock(String[] deadends, String target) {
        Set<String> forwardQueue = new HashSet<>();
        Set<String> backwardQueue = new HashSet<>();


        Set<String> visited = new HashSet<>();
        visited.addAll(Arrays.asList(deadends));



        forwardQueue.add("0000");
        backwardQueue.add(target);

        int step = 0;

        while (!forwardQueue.isEmpty() && !backwardQueue.isEmpty()) {
            // hash集合在遍历过程中不能修改，用 temp 存储扩散结果
            Set<String> temp = new HashSet<>();

            for (String lockNum : forwardQueue) {

                if (!visited.contains(lockNum)) {
                    visited.add(lockNum);

                    // 判断是否为正确密码
                    if (backwardQueue.contains(lockNum)) {
                        return step;
                    }

                    // 不同位置都扭一下
                    for (int position = 0; position < 4; position++) {
                        for (int direction = 0; direction < 2; direction++) {
                            String newLockNum = warp(lockNum, position, direction);
                            if (!visited.contains(newLockNum)) {
                                temp.add(newLockNum);
                            }
                        }
                    }
                }





            }
            step++;

            // temp 相当于 forwardQueue
            // 交换 forwardQueue 和 backwardQueue，下一轮就是 backwardQueue 扩散
            forwardQueue = backwardQueue;
            backwardQueue = temp;

        }

        return -1;

    }

    private String warp(String lock, int position, int direction){
        char[] lockArr = lock.toCharArray();

        if(direction == 1){
            lockArr[position] = lockArr[position] == '9'?'0': (char) (lockArr[position] + 1);
        }else {
            lockArr[position] = lockArr[position] == '0'?'9': (char) (lockArr[position] - 1);
        }
        return new String(lockArr);


    }
}
