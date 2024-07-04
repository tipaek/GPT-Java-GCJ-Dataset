import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        //Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Scanner in = new Scanner("4\r\n" + 
                "2 3\r\n" + 
                "-2 -3\r\n" + 
                "3 0\r\n" + 
                "-1 1");
        int T = in.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int x = in.nextInt();
            int y = in.nextInt();
            if ((x%2 != 0 && y%2 != 0) || (x%2 == 0 && y%2 == 0)) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                Point current = new Point(0, 0, 0, x+y, 1, "");
                PriorityQueue<Point> q = new PriorityQueue<Point>();
                HashSet<Point> visited = new HashSet<Point>();
                while ((current.a != x || current.b != y)) {
                    visited.add(current);
                    Point n = new Point(current.a, current.b + current.nextMove,
                            current.distTraveled + current.nextMove, 0, current.nextMove * 2, current.s+"N");
                    n.dist = n.distTraveled + Math.abs(x - n.a) + Math.abs(y - n.b);
                    if (!visited.contains(n)) {
                        q.add(n);
                    }
                    Point s = new Point(current.a, current.b - current.nextMove,
                            current.distTraveled + current.nextMove, 0, current.nextMove * 2, current.s+"S");
                    s.dist = s.distTraveled + Math.abs(x - s.a) + Math.abs(y - s.b);
                    if (!visited.contains(s)) {
                        q.add(s);
                    }
                    Point e = new Point(current.a + current.nextMove, current.b,
                            current.distTraveled + current.nextMove, 0, current.nextMove * 2, current.s+"E");
                    e.dist = e.distTraveled + Math.abs(x - e.a) + Math.abs(y - e.b);
                    if (!visited.contains(e)) {
                        q.add(e);
                    }
                    Point w = new Point(current.a - current.nextMove, current.b,
                            current.distTraveled + current.nextMove, 0, current.nextMove * 2, current.s+"W");
                    w.dist = w.distTraveled + Math.abs(x - w.a) + Math.abs(y - w.b);
                    if (!visited.contains(w)) {
                        q.add(w);
                    }
                    current = q.remove();
                }
                System.out.println("Case #" + testCase + ": " + current.s);
            }
        }
    }
    private static class Point implements Comparable<Point> {
        int a;
        int b;
        int distTraveled;
        int dist;
        int nextMove;
        String s;
        public Point(int a, int b, int distTraveled, int dist, int nextMove, String s) {
            this.a=a;
            this.b=b;
            this.distTraveled=distTraveled;
            this.dist=dist;
            this.nextMove = nextMove;
            this.s=s;
        }
        public int compareTo(Point other) {
            return this.dist - other.dist;
        }
        @Override
        public boolean equals(Object o) {
            return (o instanceof Point) && ((Point)o).a == a && ((Point)o).b == b;
        }
        @Override
        public int hashCode() {
            return this.a + this.b;
        }
    }
}
