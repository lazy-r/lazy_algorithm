# ArithmeticSlices_413

## 一、题目

- ### 介绍

  > - 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
  >
  > - 例如，以下数列为等差数列:
  >
  >   ```bash
  >   1, 3, 5, 7, 9
  >   7, 7, 7, 7
  >   3, -1, -5, -9
  >   ```
  >
  > - 以下数列不是等差数列。
  >
  >   ```bash
  >   1, 1, 2, 5, 7
  >   ```
  >
  > - 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
  >
  > - 如果满足以下条件，则称子数组(P, Q)为等差数组：
  >
  >   - 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
  >   - 函数要返回数组 A 中所有为等差数组的子数组个数。
  >
  > - 示例:
  >
  >   ```bash
  >   A = [1, 2, 3, 4]
  >   返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
  >   ```

## 二、题解

- ### 题解一

  > - 思路
  >
  >   
  >
  > - 递推公式
  >
  >   ```bash
  >   
  >   ```
  >
  > - 代码
  >
  >   ```java
  >   public class ArithmeticSlices_413 {
  >       public int numberOfArithmeticSlices(int[] A) {
  >           if(A.length < 3){
  >               return 0;
  >           }
  >           int[] result = new int[A.length];
  >   
  >           // 初始化
  >           int num = A[1] - A[0];
  >           result[2] = (A[2] - A[1]) == num?1:0;
  >           for (int i = 3; i < A.length; i++) {
  >               num = A[i] - A[i-1];
  >               for (int j = 1; j < i; j++) {
  >                   if((A[i-j] - A[i-j-1]) == num){
  >                       result[i]++;
  >                   }else {
  >                       break;
  >                   }
  >               }
  >   
  >               result[i] = result[i] + result[i-1];
  >           }
  >   
  >           return result[A.length-1];
  >       }
  >   }
  >   ```
  >
  > - 提交结果
  >
  >   ![提交结果](https://gitee.com/lazy-r/img/raw/master/blog/image-20201107211418839.png)

