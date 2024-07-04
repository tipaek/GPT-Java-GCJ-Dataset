import java.util.*;
import java.io.*;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            long targetX = in.nextLong();
            long targetY = in.nextLong();
            Queue<Point> q = new LinkedList();
            q.offer(new Point(0,0));
            long[][] dirs = new long[][]{{-1,0}, {1,0}, {0,-1}, {0, 1}};
            char[] dirsChar = new char[]{'W', 'E', 'S', 'N'};
            long step = 1;
            long halt = (Math.abs(targetX)+Math.abs(targetY))*3;
            boolean isResFound = false;
            bfs:
            while(step<halt){
                int size = q.size();
                for(int j=0; j<size; j++){
                    Point cur = q.poll();
                    if(cur.x == targetX && cur.y==targetY){
                        System.out.println("Case #" + i + ": " + cur.path);
                        isResFound = true;
                        break bfs;
                    }
                    for(int d=0; d<4; d++){
                        long nextX = cur.x + step*dirs[d][0];
                        long nextY = cur.y + step*dirs[d][1];
                        String nextPath = cur.path+dirsChar[d];
                        Point nextPoint = new Point(nextX, nextY);
                        nextPoint.path = nextPath;
                        q.offer(nextPoint);
                    }
                }
                step *= 2;
            }
            if(!isResFound) System.out.println("Case #" + i + ": IMPOSSIBLE");
        }
    }

    public static class Point{
        long x;
        long y;
        String path;
        public Point(long x, long y){
            this.x = x;
            this.y = y;
            path = "";
        }
    }
}
