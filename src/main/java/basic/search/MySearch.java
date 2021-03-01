package basic.search;

import java.util.*;

public abstract class MySearch {
    private int size = 1000;
    private int len = 10000;
    private int range = 10000;


    public abstract int search(int[] arr, int findVal);
    public abstract int optimizedSearch(int[] arr, int findVal);

    public void test(int[] arr, int findVal){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        int rightIndex = list.indexOf(findVal);
        int resultIndex = search(arr, findVal);
        if(resultIndex >= 0){
            if(findVal == arr[resultIndex]){
                System.out.println("查询成功，查询的数字为"+findVal+",查询结果为"+arr[resultIndex]);
            }else {
                System.out.println("arr = "+Arrays.toString(arr));
                System.out.println("查询失败，查询的数字为"+findVal+",查询结果为"+arr[resultIndex]);
            }
        }else {
            System.out.println("arr = "+Arrays.toString(arr));
            if(rightIndex == resultIndex){
                System.out.println("查询成功，查询的数字为"+findVal+",未查询到");
            }else {
                System.out.println("查询失败，查询的数字为"+findVal+",未查询到");
            }
        }

    }

    public void test(boolean ordered){

        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(range);
        }

        if(ordered){
            Arrays.sort(arr);
        }

        test(arr, new Random().nextInt(range));
    }



}
