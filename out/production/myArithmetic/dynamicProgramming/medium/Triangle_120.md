# Triangle_120

## 一、题目

- ### 介绍

  > - 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
  >
  > - 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
  >
  > - 例如，给定三角形：
  >
  >   ```bash
  >   [
  >        [2],
  >       [3,4],
  >      [6,5,7],
  >     [4,1,8,3]
  >   ]
  >   ```
  >
  > - 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
  >
  > - 说明：
  >
  >   如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。

## 二、题解

- ### 题解一

  > - ```java
  >   public class Triangle_120 {
  >       public int minimumTotal(List<List<Integer>> triangle) {
  >           // 初始化数组，使用result来记录最短路径
  >           List<List<Integer>> minimumRows = new ArrayList<>();
  >           // 0行0列的最佳路径为本身数值
  >           minimumRows.add(triangle.get(0));
  >   
  >           for (int i = 1; i < triangle.size(); i++) {
  >               // 保存每行的最短路径
  >               List<Integer> currentMinimumRow = new ArrayList<>();
  >               // 获取上一行最短路径，方便进行比较
  >               List<Integer> preMinimumRow = minimumRows.get(i-1);
  >               // 获取当前行的数值，方便进行比较
  >               List<Integer> currentRow = triangle.get(i);
  >               // 获取当前行的列数
  >               int colSize = currentRow.size();
  >               for (int j = 0; j < colSize; j++) {
  >                   if(j == 0){// 若为每行的第一列
  >                       currentMinimumRow.add(preMinimumRow.get(j)+currentRow.get(j));
  >                   }else if(j == colSize-1){// 若为每行的最后一列
  >                       currentMinimumRow.add(preMinimumRow.get(j-1)+currentRow.get(j));
  >                   }else {// 若为每行的中间列
  >                       currentMinimumRow.add(
  >                               min(preMinimumRow.get(j-1),preMinimumRow.get(j))+currentRow.get(j)
  >                       );
  >                   }
  >               }
  >               minimumRows.add(currentMinimumRow);
  >           }
  >           // 获取最后一行里的最小数值即为最短路径
  >           int result = minimumRows.get(minimumRows.size() - 1).get(0);
  >           for (Integer i : minimumRows.get(minimumRows.size() - 1)) {
  >               result = result < i ? result:i;
  >           }
  >           return result;
  >       }
  >       public int min(int a, int b){
  >           return a<b?a:b;
  >       }
  >   }
  >   
  >   ```

- ### 题解二

  > - ```java
  >   public class Triangle_120 {
  >       public int minimumTotal(List<List<Integer>> triangle) {
  >           // 初始化数组，使用result来记录最短路径
  >           int[][] minimumRows = new int[2][triangle.size()];
  >           // 0行0列的最佳路径为本身数值
  >           minimumRows[0][0] = triangle.get(0).get(0);
  >           int currentIdx = 0;
  >           int preIdx = 0;
  >           for (int i = 1; i < triangle.size(); i++) {
  >               // 保存每行的最短路径
  >               currentIdx = i%2;
  >               int[] currentMinimumRow = minimumRows[currentIdx];
  >               // 获取上一行最短路径，方便进行比较
  >               preIdx = (i-1)%2;
  >               int[] preMinimumRow = minimumRows[preIdx];
  >               // 获取当前行的数值，方便进行比较
  >               List<Integer> currentRow = triangle.get(i);
  >               // 获取当前行的列数
  >               int colSize = currentRow.size();
  >               for (int j = 0; j < colSize; j++) {
  >                   if(j == 0){// 若为每行的第一列
  >                       currentMinimumRow[j] = (preMinimumRow[j]+currentRow.get(j));
  >                   }else if(j == colSize-1){// 若为每行的最后一列
  >                       currentMinimumRow[j] = (preMinimumRow[j-1]+currentRow.get(j));
  >                   }else {// 若为每行的中间列
  >                       currentMinimumRow[j] = (
  >                               min(preMinimumRow[j-1],preMinimumRow[j])+currentRow.get(j)
  >                       );
  >                   }
  >               }
  >           }
  >           // 获取最后一行里的最小数值即为最短路径
  >           int result = minimumRows[currentIdx][0];
  >           for (Integer i : minimumRows[currentIdx]) {
  >               result = result < i ? result : i;
  >           }
  >           return result;
  >   
  >       }
  >       public int min(int a, int b){
  >           return a<b?a:b;
  >       }
  >   }
  >   ```

- ### 题解三

  > - ```java
  >   public class Triangle_120 {
  >       public int minimumTotal(List<List<Integer>> triangle) {
  >           // 初始化数组，使用minimumRows来记录最短路径
  >           int[][] minimumRows = new int[2][triangle.size()];
  >           int init = (triangle.size()-1)%2;
  >           // 底行的最佳路径为本身数值
  >           List<Integer> lastRow = triangle.get(minimumRows[0].length-1);
  >           for (int i = 0; i < minimumRows[init].length; i++) {
  >               minimumRows[init][i] = lastRow.get(i);
  >           }
  >   
  >           int currentIdx = init;
  >           int rearIdx = init;
  >           for (int i = triangle.size()-2; i >= 0; i--) {
  >               // 保存每行的最短路径
  >               currentIdx = i%2;
  >               int[] currentMinimumRow = minimumRows[currentIdx];
  >               // 获取下一行最短路径，方便进行比较
  >               rearIdx = (i+1)%2;
  >               int[] rearMinimumRow = minimumRows[rearIdx];
  >               // 获取当前行的数值，方便进行比较
  >               List<Integer> currentRow = triangle.get(i);
  >               // 获取当前行的列数
  >               int colSize = currentRow.size();
  >               for (int j = 0; j < colSize; j++) {
  >                   currentMinimumRow[j] = currentRow.get(j) + min(rearMinimumRow[j],rearMinimumRow[j+1]);
  >               }
  >           }
  >   
  >           return minimumRows[0][0];
  >   
  >       }
  >       public int min(int a, int b){
  >           return a<b?a:b;
  >       }
  >   }
  >   ```
  >
  > - 
