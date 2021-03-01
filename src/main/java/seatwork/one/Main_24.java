package seatwork.one;

import java.util.*;


public class Main_24 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        in.nextLine();

        float[][][] points = new float[size][][];

        for (int i = 0; i < size; i++) {
            String[] line = in.nextLine().split(",");
            points[i] = new float[line.length][2];
            for (int j = 0; j < points[i].length; j++) {
                String[] spot = line[j].split(" ");
                points[i][j][0] = Float.parseFloat(spot[0]);
                points[i][j][1] = Float.parseFloat(spot[1]);
            }

        }
        for (int i = 0; i < points.length; i++) {
            calculate(points[i]);
        }
    }

    // 表示横坐标
    private static int abscissa = 0;
    // 表示纵坐标
    private static int ordinate = 1;
    // 临时点数组，防止后面频繁开辟新空间
    private static float[][] temp;
    // 根据纵坐标升序排列
    private static float[][] pointsAscendingByOrdinate;

    private static void calculate(float[][] points) {
        // 临时点数组，防止后面频繁开辟新空间
        temp = new float[points.length][5];
        // 后续计算会根据点纵坐标升序排列存入该数组
        pointsAscendingByOrdinate = new float[points.length][2];

        // 预处理：将所有点按横坐标升序排列
        sort(points, abscissa, 0, points.length-1);


        List<float[]> nearestPoints = getNearestPoints(points, 0, points.length-1);
        float[][] result = new float[nearestPoints.size()][5];
        nearestPoints.toArray(result);
        sort(result, 0, 0, result.length-1);

        for (int i = 0; i < result.length; i++) {
            printPoints(result[i]);
            System.out.print(i == result.length - 1?"":",");
        }
        System.out.println();
    }

    private static void printPoints(float[] pairPoints) {
        System.out.print(transform(pairPoints[0])+" "+transform(pairPoints[1])+","+transform(pairPoints[2])+" "+transform(pairPoints[3]));


    }

    private static String transform(float coordinate) {
//        System.out.println("coordinate = "+coordinate+", (int)coordinate = "+(int)coordinate+", result = "+((Math.abs(coordinate - (int)coordinate) < 1e-6?(int)coordinate:coordinate) + ""));
//        System.out.println(coordinate - (int)coordinate < 1e-6);
        if(Math.abs(coordinate - (int)coordinate) < 1e-6){
//            System.out.print((int)coordinate);
            return (int)coordinate+"";
        }else {
            return coordinate+"";
//            System.out.print(coordinate);
        }

//        return (Math.abs(coordinate - (int)coordinate) < 1e-6?(int)coordinate:coordinate) + "";

    }

    private static List<float[]> getNearestPoints(float[][] points, int left, int right) {
        // 当左右边界包含的元素小于时，则直接计算最近点对
        if(right - left <= 2){
            // 1、将points[left:right]赋值给pointsAscendingByOrdinate[left:right]
            for (int i = left; i <= right; i++) {
                assignment(pointsAscendingByOrdinate[i], points[i]);
            }
            // 2、将pointsAscendingByOrdinate[left:right]按y坐标升序排序
            merge(pointsAscendingByOrdinate, ordinate, left, right);

            // 3、计算最近点对
            return minimumNearestPoints(points, left, right);
        }

        int mid = (left + right)/2;
        // 分别获取左右半部分的最近点对
        List<float[]> leftNearestPoints = getNearestPoints(points, left, mid);
        List<float[]> rightNearestPoints = getNearestPoints(points, mid + 1, right);
        // 获取左右半部分距离最近的最近点对
        List<float[]> nearestPoints = null;
        if(equal(leftNearestPoints.get(0)[4], rightNearestPoints.get(0)[4])){
            nearestPoints = new ArrayList<>();
            for (int i = 0; i < leftNearestPoints.size(); i++) {
                nearestPoints.add(leftNearestPoints.get(i));
            }
            for (int i = 0; i < rightNearestPoints.size(); i++) {
                nearestPoints.add(rightNearestPoints.get(i));
            }
        }else {
            nearestPoints = leftNearestPoints.get(0)[4] < rightNearestPoints.get(0)[4]?leftNearestPoints:rightNearestPoints;
        }

        float nearestDistance = nearestPoints.get(0)[4];

        // 将pointsAscendingByOrdinate[left:right]按y坐标升序排序
        merge(pointsAscendingByOrdinate, ordinate, left, right);

        // 获取距离分界线的距离小于最近点对的距离的所有点
        int count = 0;
        for (int i = left; i <= right; i++) {
            if(Math.abs(points[i][abscissa] - points[mid][abscissa]) < Math.sqrt(nearestDistance)){
                temp[count][abscissa] = points[i][abscissa];
                temp[count++][ordinate] = points[i][ordinate];
            }
        }


        // 从下至上获取最近的七个点的距离
        for (int i = 0; i < count; i++) {
            for (int j = i+1; j < (i+7 <= count?i+7:count); j++) {
                float distance = getDistance(temp[i], temp[j]);
                float[] pairPoints = new float[5];
                pairPoints[0] = temp[i][0];
                pairPoints[1] = temp[i][1];
                pairPoints[2] = temp[j][0];
                pairPoints[3] = temp[j][1];
                pairPoints[4] = distance;

                if(distance < nearestDistance){
                    nearestPoints = new ArrayList<>();
                    nearestDistance = distance;
                    nearestPoints.add(pairPoints);
                }else if(equal(distance, nearestDistance) && notRepeatPairPoints(pairPoints, nearestPoints)){
                    nearestPoints.add(pairPoints);
                }
            }
        }



        return nearestPoints;
    }

    private static boolean notRepeatPairPoints(float[] pairPoints, List<float[]> nearestPoints) {
        for (float[] nearestPoint : nearestPoints) {
            boolean repeat = true;
            for (int i = 0; i < nearestPoint.length - 1; i++) {
                repeat = repeat?pairPoints[i] == nearestPoint[i]:false;
            }
            if(repeat){
                return false;
            }
        }
        return true;
    }

    private static List<float[]> minimumNearestPoints(float[][] points, int left, int right) {
        int len = right - left + 1;
        // pairPoints数据内容：[point1的横坐标, point1的纵坐标, point2的横坐标, point2的纵坐标, 两点距离的平方]
        float[][] pairPoints = new float[len*(len - 1)/2][5];

        int index = 0;
        for (int i = left; i < right; i++) {
            for (int j = i + 1; j <= right; j++) {
                pairPoints[index][0] = points[i][0];
                pairPoints[index][1] = points[i][1];
                pairPoints[index][2] = points[j][0];
                pairPoints[index][3] = points[j][1];
                pairPoints[index++][4] = getDistance(points[i], points[j]);
            }
        }

        sort(pairPoints, 4, 0, pairPoints.length-1);

        List<float[]> nearestPoints = new ArrayList<>();
        float nearestDistance = pairPoints[0][4];
        nearestPoints.add(pairPoints[0]);

        index = 1;
        while (index < pairPoints.length && equal(pairPoints[index][4], nearestDistance)){
            nearestPoints.add(pairPoints[index++]);
        }

        return nearestPoints;
    }

    private static boolean equal(float a, float b) {
        return Math.abs(a - b) < 1e-6;
    }


    private static float getDistance(float[] point1, float[] point2){
        float abscissaDifference = point2[abscissa] - point1[abscissa];
        float ordinateDifference = point2[ordinate] - point1[ordinate];
        return (float) (Math.pow(abscissaDifference, 2) + Math.pow(ordinateDifference, 2));
    }

    private static void sort(float[][] points, int dimension, int left, int right) {
        // 当左右边界只包含一个元素时，结束递归
        if(left >= right){
            return;
        }

        int mid = (left + right)/2;
        sort(points, dimension, left, mid);
        sort(points, dimension, mid + 1, right);
        merge(points, dimension, left, right);

    }

    private static void merge(float[][] points, int dimension, int left, int right) {
        int mid = (left + right)/2;
        int leftIndex = left;
        int rightIndex = mid + 1;
        int tempIndex = left;

        while (leftIndex <= mid && rightIndex <= right){
            assignment(temp[tempIndex++], points[leftIndex][dimension] < points[rightIndex][dimension]?points[leftIndex++]:points[rightIndex++]);
        }

        while (leftIndex <= mid){
            assignment(temp[tempIndex++], points[leftIndex++]);
        }

        while (rightIndex <= right){
            assignment(temp[tempIndex++], points[rightIndex++]);
        }


        for (int i = left; i <= right; i++) {
            assignment(points[i], temp[i]);
        }
    }

    private static void assignment(float[] assignedArr, float[] assigningArr) {
        int len = assignedArr.length < assigningArr.length?assignedArr.length:assigningArr.length;
        for (int i = 0; i < len; i++) {
            assignedArr[i] = assigningArr[i];
        }

    }


}
