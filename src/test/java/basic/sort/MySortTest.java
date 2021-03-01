package basic.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 *
 */
public class MySortTest {

    @Test
    public void sort() {
//        testEfficiency(new HeapSort());
//        testEfficiency(new MergeSort());
//        testEfficiency(new QuickSort());
//        testEfficiency(new InsertSort());
//        testEfficiency(new SelectSort());
//        testEfficiency(new BubbleSort());
//        testEfficiency(new ShellSort());
//        testEfficiency(new CountSort());
//        testEfficiency(new BucketSort());
//        testEfficiency(new RadixSort());

        String str = "985 1889 1687 -2182 -1489 -3636 920 -4233 2111 2517 4253 -4986 -4038 -3845 -4628 -2202 4087 -2361 1402 -3778 -4242 -651 -2469 1345 -2036 3714 -2663 4156 -1798 4382 -1671 4344 2743 2385 4330 -1469 462 3798 -3605 -4410 -36 -4708 1741 3080 -1791 -747 -4150 -4568 2157 682 -3723 1489 1013 3955 -1956 -3675 -4400 -1278 -501 -237 3129 692 4448 2024 139 4902 1047 -4934 3741 -3887 449 -3281 1512 3491 -1454 3601 3287 4428 2240 -2109 3959 -4596 -2324 2528 4957 -3799 1569 -805 3503 -2561 -1600 3487 2977 375 -4442 2132 4757 2280 -4203 -2238";
        str = "0 1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9 9 10 10 11 11 12 12 13 13 14 14 15 15 16 16 17 17 18 18 19 19 20 20 21 21 22 22 23 23 24 24 25 25 26 26 27 27 28 28 29 29 30 30 31 31 32 32 33 33 34 34 35 35 36 36 37 37 38 38 39 39 40 40 41 41 42 42 43 43 44 44 45 45 46 46 47 47 48 48 49 49 50 50 51 51 52 52 53 53 54 54 55 55 56 56 57 57 58 58 59 59 60 60 61 61 62 62 63 63 64 64 65 65 66 66 67 67 68 68 69 69 70 70 71 71 72 72 73 73 74 74 75 75 76 76 77 77 78 78 79 79 80 80 81 81 82 82 83 83 84 84 85 85 86 86 87 87 88 88 89 89 90 90 91 91 92 92 93 93 94 94 95 95 96 96 97 97 98 98 99 99 100";
        str = "-477 -333 -245 -434 -57 -277 -464 -405 -126 82 -68 -370 -126 342 -134 148 -308 313 -247 127 -130 79 87 466 93 -193 237 466 104 130 -443 -454 -306 30 -46 307 -198 176 288 -390 47 -108 -476 263 36 29 396 -416 -310 255 484 69 408 469 -88 150 362 330 -349 22 294 176 285 349 291 -80 386 -232 -342 -133 108 -117 -412 -205 470 -250 -354 24 -169 -407 146 -310 426 -113 428 -146 -488 -211 -377 -322 -482 284 24 327 -101 376 334 -69 -213 72";
        str = "-2541 -773 2804 453 -4185 1042 -2807 3290 2808 -2081 960 529 -1952 -3598 4402 3369 2841 1698 -2145 -1456 4276 -2663 4366 2638 193 3328 560 265 4893 3752 -145 -4719 2325 2565 -3229 -3941 -1837 4662 -1569 2951 4720 -2245 -534 -1514 2970 -561 -417 -1409 4054 3009 -1211 -3762 -1380 -4993 3913 -2813 -3893 -2709 1448 1282 -2362 -3499 -4021 1670 -4410 4164 514 -1333 83 1444 4877 4594 -2325 3522 963 859 325 -34 -795 -1242 3389 -933 -1196 1080 -235 -3883 -4542 2451 3661 -2162 4166 2500 1482 -2191 1501 -2516 -804 577 1176 2754";
        str = "79 92 75 47 46 60 84 45 30 5 4 81 74 26 12 2 30 65 56 27 9 3 67 12 91 15 68 43 21 88 44 92 75 89 56 7 94 31 28 73 40 3 59 88 15 35 89 24 33 75 39 64 71 73 19 4 17 94 13 77 72 33 98 4 11 3 59 56 64 72 55 74 70 47 42 73 19 41 53 49 58 8 43 11 1 27 30 25 72 34 81 32 49 10 68 44 22 12 69";
        str = "81 51 53 3 56 2 45 71 57 65 32 19 51 4 33 48 10 12 14 36 27 8 43 13 84 99 23 27 54 2 29 49 63 34 52 12 38 53 82 18 48 5 81 32 91 88 38 48 38 29 99 33 3 50 66 49 25 51 46 1 81 85 38 85 70 49 87 10 99 57 30 91 24 54 86 59 61 93 10 2 84 16 58 4 67 18 31 59 30 64 0 34 49 22 7 82 74 28 36";
        str = "6 58 8 70 70 18 33 22 35 35 92 73 10 21 89 4 50 63 83 82 30 57 68 9 30 82 68 2 68 36 30 40 84 74 43 66 75 3 11 60 21 35 73 16 16 37 64 58 69 68 34 41 36 48 78 54 61 63 69 45 81 6 56 41 44 79 61 4 79 46 18 17 68 37 96 36 19 63 71 71 62 82 71 1 74 87 57 12 6 82 83 93 68 80 78 69 65 68 72";
        System.out.println(str.split(" ").length);


//        int[] arr =new int[]{8, 7, 1, 2, 6, 2, 16};
//        new RadixSort().sort(arr);
//        System.out.println(Arrays.toString(arr));
    }
    public void testEfficiency(MySort sort){
        // 创建10000个长度不等的数组
        int size = 10000;
        int len = 10000;
        int range = 10000;

        int[][] arr = new int[size][];
        int[][] optimizedArr = new int[size][];
        int[][] comparedArr = new int[size][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[new Random().nextInt(len)];
            comparedArr[i] = new int[arr[i].length];
            optimizedArr[i] = new int[arr[i].length];
            // 创建测试数组
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = new Random().nextInt(range);
                comparedArr[i][j] = arr[i][j];
                optimizedArr[i][j] = arr[i][j];
            }
            // 利用java自带sort，将测试数组排序用作答案排序比较
            Arrays.sort(comparedArr[i]);
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            sort.sort(arr[i]);
        }
        long end = System.currentTimeMillis();
        System.out.println(compare(arr,comparedArr)?"排序成功，耗时=>"+(end-start)+"毫秒":"排序失败");


//        start = System.currentTimeMillis();
//        for (int i = 0; i < arr.length; i++) {
//            sort.optimizedSort(optimizedArr[i]);
//        }
//        end = System.currentTimeMillis();
//        System.out.println(compare(optimizedArr,comparedArr)?"优化排序成功，耗时=>"+(end-start)+"毫秒":"排序失败");
    }

    public boolean compare(int[][] arr, int[][] comparedArr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] != comparedArr[i][j]){
                    System.out.println("正确结果=>"+Arrays.toString(comparedArr[i]));
                    System.out.println("错误结果=>"+Arrays.toString(arr[i]));
                    return false;
                }
            }
        }
        return true;
    }



    @Test
    public void optimizedSort() {

    }
}
