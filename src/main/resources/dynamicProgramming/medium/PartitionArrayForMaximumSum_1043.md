# PartitionArrayForMaximumSum_1043

## 一、题目

- ### 介绍

  > - 给你一个整数数组 arr，请你将该数组分隔为长度最多为 k 的一些（连续）子数组。分隔完成后，每个子数组的中的所有值都会变为该子数组中的最大值。
  >
  > - 返回将数组分隔变换后能够得到的元素最大和。
  >
  > - **注意**，原数组和分隔后的数组对应顺序应当一致，也就是说，你只能选择分隔数组的位置而不能调整数组中的顺序。
  >
  > - 示例 1：
  >
  >   ```bash
  >   输入：arr = [1,15,7,9,2,5,10], k = 3
  >   输出：84
  >   解释：
  >   因为 k=3 可以分隔成 [1,15,7] [9] [2,5,10]，结果为 [15,15,15,9,10,10,10]，和为 84，是该数组所有分隔变换后元素总和最大的。
  >   若是分隔成 [1] [15,7,9] [2,5,10]，结果就是 [1, 15, 15, 15, 10, 10, 10] 但这种分隔方式的元素总和（76）小于上一种。 
  >   ```
  >
  > - 示例 2：
  >
  >   ```bash
  >   输入：arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
  >   输出：83
  >   示例 3：
  >   
  >   输入：arr = [1], k = 1
  >   输出：1
  >   ```
  >
  > - 提示：
  >
  >   ```bash
  >   1 <= arr.length <= 500
  >   0 <= arr[i] <= 109
  >   1 <= k <= arr.length
  >   ```

## 二、题解

- ### 题解一

  > - 思路
  >
  >   ![思路](https://gitee.com/lazy-r/img/raw/master/blog/1.jpg)
  >
  > - 递推公式
  >
  >   ```bash
  >   f[i+1]：表示从arr中0-i的最大和
  >   
  >   f[0] = 0
  >   f[i+1] = max{f[i+1-len] + max{arr[i], ... ,arr[i-1-len]}*len},1≤len≤k
  >   ```
  >
  > - 代码
  >
  >   ```java
  >   public class PartitionArrayForMaximumSum_1043 {
  >       public int maxSumAfterPartitioning(int[] arr, int k) {
  >           // 保存结果
  >           int[] result = new int[arr.length+1];
  >           for (int i = 0; i < arr.length; i++) {
  >               // 用来记录不同划分组合中的最大值
  >               int tempMax = arr[i];
  >               // 计算不同划分组合的最大和
  >               for (int j = 1; j <= k&&i-j+1>=0; j++) {
  >                   tempMax = tempMax>arr[i-j+1]?tempMax:arr[i-j+1];
  >                   result[i+1] = result[i+1]>result[i+1-j]+tempMax*j?result[i+1]:result[i+1-j]+tempMax*j;
  >               }
  >           }
  >   
  >           return result[arr.length];
  >       }
  >   }
  >   ```
  >
  > - ![提交结果](https://gitee.com/lazy-r/img/raw/master/blog/2.png)
