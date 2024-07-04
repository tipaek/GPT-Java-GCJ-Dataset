import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static int[][] pascal;

    public static void main(String[] args) {
        pascal = new int[500][];
        for (int r=0; r<500; r++) {
            pascal[r] = new int[r+1];
            pascal[r][0] = 1;
            pascal[r][r] = 1;
            for (int c=1; c<r; c++) {
                pascal[r][c] = pascal[r-1][c-1] + pascal[r-1][c];
            }
        }
        
//        for (int sum=1; sum<=1000; sum++) {
//            List<Point> list = find(sum);
//            if (list.size() > 500) {
//                System.out.println("BUG SIZE " + sum);
//            }
//            int actualSum = 0;
//            for (Point p : list) {
//                actualSum += pascal[p.x][p.y];
//            }
//            if (actualSum != sum) {
//                System.out.println("BUG SUM " + sum + " " + actualSum);
//            }
//            if (new HashSet<Point>(list).size() != list.size()) {
//                System.out.println("NOT DISTINCT " + sum);
//            }
//        }
        
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t=1; t<=T; t++) {
            int N = in.nextInt();
            List<Point> list = find(N);
            StringBuilder sb = new StringBuilder();
            sb.append("Case #").append(t).append(":\n");
            for (Point p : list) {
                sb.append(p.x+1).append(' ').append(p.y+1).append('\n');
            }
            System.out.print(sb);
        }
    }

    static List<Point> find(int sum) {
        Queue<Data> queue = new PriorityQueue<Data>(new Comparator<Data>() {
            public int compare(Data o1, Data o2) {
                return o2.sum - o1.sum;
            }
        });
        Data d = new Data();
        d.list = new ArrayList<Point>();
        d.list.add(new Point(0,0));
        d.sum = pascal[0][0];
        queue.add(d);
        while (true) {
            do {
                d = queue.poll();
            } while (d.sum > sum);
            if (d.sum == sum) {
                return d.list;
            }
            
            Point p = d.list.get(d.list.size()-1);
            if (p.x > 0) {
                if (p.y > 0) {
                    queue.add(d.extend(p.x-1,p.y-1));
                }
                if (p.x > p.y) {
                    queue.add(d.extend(p.x-1,p.y));
                }
            }
            if (p.y > 0) {
                queue.add(d.extend(p.x,p.y-1));
            }
            if (p.y < p.x) {
                queue.add(d.extend(p.x,p.y+1));
            }
            queue.add(d.extend(p.x+1,p.y));
            queue.add(d.extend(p.x+1,p.y+1));
        }
    }

    static class Data {
        int sum;
        List<Point> list;
        Data extend(int x, int y) {
            Data d = new Data();
            Point nextPoint = new Point(x,y);
            if (list.contains(nextPoint)) {
                d.sum = Integer.MAX_VALUE;
            } else {
                d.sum = sum + pascal[x][y];
                d.list = new ArrayList<Point>(list);
                d.list.add(nextPoint);
            }
            return d;
        }
    }

    
}
