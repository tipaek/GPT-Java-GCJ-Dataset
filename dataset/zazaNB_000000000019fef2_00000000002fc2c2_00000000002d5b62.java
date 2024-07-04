
import java.io.*;
import java.util.*;

public class Solution {
    public static class Point {
        public long x;
        public long y;
        public String path;
        public long step;
        public Point(long x, long y, String path, long step) {
            this.x = x;
            this.y = y;
            this.path = path;
            this.step = step;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int X = in.nextInt();
            int Y = in.nextInt();
            System.out.print("Case #" + i + ": ");
            if (((X % 2 == 1 || X % 2 == -1) && (Y % 2 == 1 || Y % 2 == -1)) ||
                    (X % 2 == 0 && Y % 2 == 0)) {
                System.out.println("IMPOSSIBLE");
                continue;
            }
            Set<String> visited = new HashSet<>();
            visited.add(0+" "+0);
            Queue<Point> pq = new PriorityQueue<>(10000000, new Comparator<Point>() {
                public int compare(Point a, Point b) {
                    if (a.path.length() == b.path.length()) {
                        return ((a.x - X) * (a.x - X) + (a.y - Y) * (a.y - Y) >
                                                        - (b.x - X) * (b.x - X) - (b.y - Y) * (b.y - Y)) ? 1 : -1;
                    }
                    return a.path.length() - b.path.length();
                }
            });
            pq.offer(new Point(0, 0, "", 1));
            long[] dx = {1, -1, 0, 0};
            long[] dy = {0, 0, 1, -1};
            char[] dir = {'E', 'W', 'N', 'S'};
            while (pq.size() > 0) {
                Point cur = pq.poll();
                long curX = cur.x;
                long curY = cur.y;
                long curStep = cur.step;
                long nextStep = curStep * 2;
                if (cur.x == X && cur.y == Y) {
                    System.out.println(cur.path);
                    break;
                }
                for (int j = 0; j < 4; j++) {
                    long nextX = curX + dx[j]*curStep;
                    long nextY = curY + dy[j]*curStep;
                    String key = nextX + " " + nextY;
                    if (!visited.contains(key)) {
                        visited.add(key);
                        pq.offer(new Point(nextX, nextY, cur.path+dir[j], nextStep));
                    }
                }
            }
        }
    }
}