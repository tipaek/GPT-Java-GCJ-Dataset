import java.util.*;
import java.io.*;
public class Solution {
    static class Point {
        int x;
        int y;
        String d;
        int l;
        
        public Point(int x, int y, String d, int l) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.l = l;
        }
    
        @Override
        public boolean equals(Object obj) {
            Point point = (Point) obj;
            return this.x == point.x && this.y == point.y && this.d.equals(point.d) && this.l == point.l;
        }
        
        public boolean end(int x, int y) {
            return this.x == x && this.y == y;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        for (int tt = 1; tt <= t; tt++) {
            String s1 = in.readLine();
            String[] tmp1 = s1.split(" ");
            int x = Integer.parseInt(tmp1[0]);
            int y = Integer.parseInt(tmp1[1]);
            findSolution(tt, x, y);
        }
    }
    
    public static void findSolution(int index, int x, int y) {
        int l = 0;
        HashSet<Point> level0 = new HashSet<>();
        level0.add(new Point(0, 0, "", 0));
        HashSet<Point> level1;
        boolean valid = true;
        if (x  == y || -x == y) {
            valid = false;
        }
        while (valid) {
            valid = true;
            int nl =  l == 0 ? 1 : l * 2;
            level1 = new HashSet<>();
            for (Point point : level0) {
                int i = point.x;
                int j = point.y;
                if (point.x == x && point.y == y) {
                    System.out.println("Case #" + index + ": " + point.d);
                    return;
                }
                Point w = new Point(i - nl, j, point.d + "W", nl);
                if (w.end(x, y)) {
                    System.out.println("Case #" + index + ": " + w.d);
                    return;
                }
                Point e = new Point(i + nl, j, point.d + "E", nl);
                if (w.end(x, y)) {
                    System.out.println("Case #" + index + ": " + e.d);
                    return;
                }
                Point n = new Point(i, j + nl, point.d + "N", nl);
                if (n.end(x, y)) {
                    System.out.println("Case #" + index + ": " + n.d);
                    return;
                }
                Point s = new Point(i, j - nl, point.d + "S", nl);
                if (s.end(x, y)) {
                    System.out.println("Case #" + index + ": " + s.d);
                    return;
                }
                level1.add(w);
                level1.add(e);
                level1.add(n);
                level1.add(s);
            }
            level0 = level1;
            
            l++;
        }
        System.out.println("Case #" + index + ": IMPOSSIBLE");
    }
    
}
