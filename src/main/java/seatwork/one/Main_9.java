package seatwork.one;

import java.util.*;

public class Main_9 {

    static class Point implements Comparable<Point>{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            // 按照横坐标升序排序，若横坐标相同则按照纵坐标升序排序
            return this.x == o.x?this.y - o.y:this.x - o.x;
        }

        @Override
        public String toString() {
            return "["+x+","+y+"]";
        }
    }


    static class Vector implements Comparable<Vector>{
        Point point;
        Point vector;
        Point origin;
        double module;
        double angle;
        public Vector(Point point){
            this.point = point;
        }

        public void setVector(Point origin){
            this.origin = origin;
            this.vector = new Point(point.x - origin.x, point.y - origin.y);
            this.module = Math.pow(point.x - origin.x, 2) + Math.pow(point.y - origin.y, 2);
            double cos = (double)this.vector.x/Math.sqrt(Math.pow(this.vector.x, 2)+Math.pow(this.vector.y, 2));
            this.angle = Math.toDegrees(Math.acos(cos));
            this.angle = this.vector.y < 0?-this.angle:angle;
        }

        @Override
        public int compareTo(Vector o) {
            // 根据角度升序排序，若角度相同则根据模升序排序
            return Math.abs(this.angle - o.angle) < 1e-6?Math.abs(this.module - o.module) < 1e-6?0:o.module - this.module>0?1:-1:this.angle - o.angle > 0?1:-1;
        }

        @Override
        public String toString() {
            return "point = "+point+", vector = "+vector+", module = "+module+", angle = "+angle;
        }

        public boolean isLeft(Point otherVector){
            int x = otherVector.x;
            int y = otherVector.y;
            int t = this.vector.x*y - this.vector.y*y + this.origin.x*this.point.y - this.origin.y*this.point.x;
            return this.vector.x*y - this.vector.y*y + this.origin.x*this.point.y - this.origin.y*this.point.x > 0;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        Point[][] points = new Point[size][];

        for (int i = 0; i < size; i++) {
            int len = in.nextInt();
            points[i] = new Point[len];
            for (int j = 0; j < len; j++) {
                points[i][j] = new Point(in.nextInt(), in.nextInt());
            }
        }

        for (int i = 0; i < size; i++) {
            calculate(points[i]);
        }
    }


    private static void calculate(Point[] points) {
        if(points.length < 3){
            System.out.println("-1");
            return;
        }
        Stack<Vector> vertexSet = new Stack<>();
        Stack<Vector> pointSet = new Stack<>();

        Arrays.sort(points);
        Point lowerLeftPoint = points[0];


        List<Vector> vectors = new ArrayList<>();
        for (int i = 1; i < points.length; i++) {
            Vector vector = new Vector(points[i]);
            vector.setVector(lowerLeftPoint);
            vectors.add(vector);
        }

        vectors.sort(new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                // 根据角度升序排序，若角度相同则根据模升序排序
                return Math.abs(o1.angle - o2.angle) < 1e-6?Math.abs(o1.module - o2.module) < 1e-6?0:o1.module - o2.module>0?1:-1:o1.angle - o2.angle > 0?1:-1;
            }
        });


        // 预处理
        Vector origin = new Vector(lowerLeftPoint);
        origin.setVector(lowerLeftPoint);
        vertexSet.push(origin);
        int index = 0;
        List<Vector> temp = new ArrayList<>();

        for (Vector vector : vectors) {
            if(Math.abs(vectors.get(0).angle - vector.angle) < 1e-6){
                vertexSet.push(vector);
                index++;
            }else {
                break;
            }
        }



        for (int i = vectors.size() - 1  ; i >= index; i--) {
            pointSet.add(vectors.get(i));
        }
        if(pointSet.isEmpty()){
            System.out.println("-1");
            return;
        }



        while (!pointSet.isEmpty()){
            Vector nextVector = pointSet.pop();
            Vector postVector = vertexSet.peek();

            Point nextPoint = nextVector.point;
            Point postPoint = postVector.point;

            Point unknownPoint = pointSet.isEmpty()?lowerLeftPoint:pointSet.peek().point;
            int position = position(postPoint, nextPoint, unknownPoint);
            if(position >= 0) {
                vertexSet.push(nextVector);
            }else {
                vertexSet.pop();
                pointSet.push(postVector);
            }
        }

        Vector lastVector = vertexSet.peek();
        for (int i = 0; i < vectors.size(); i++) {
            if(lastVector != vectors.get(i) && Math.abs(vectors.get(i).angle - lastVector.angle) < 1e-6){
                vertexSet.push(vectors.get(i));
            }
        }



        print(vertexSet);


    }

    private static void print(Stack<Vector> vertexSet) {
        Point[] result = new Point[vertexSet.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = vertexSet.pop().point;
        }

        Arrays.sort(result);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i].x+" "+result[i].y);
            if(i != result.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    private static int position(Point start, Point end, Point unknown){
        int position = (start.y - end.y)*unknown.x + (end.x - start.x)*unknown.y + start.x*end.y - end.x*start.y;
        return position;
    }



}
