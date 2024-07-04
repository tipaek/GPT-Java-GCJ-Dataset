import java.util.*;
import java.io.*;

public class Solution {

    public static class Point {
        int pos, id;
        boolean isStart;

        Point(int id, int pos, boolean isStart) {
            this.id = id;
            this.pos = pos;
            this.isStart = isStart;
        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int t = reader.nextInt();

        for (int z = 1; z <= t; z++) {
            int n = reader.nextInt();
            Point[] points = new Point[2 * n];

            for (int i = 0; i < n; i++) {
                int start = reader.nextInt();
                int end = reader.nextInt();

                points[i] = new Point(i, start, true);
                points[i + n] = new Point(i, end, false);
            }

            char[] assignment = new char[n];
            int[] active = new int[2];
            Arrays.fill(active, -1);

            Arrays.sort(points, new PointComparator());
            int activeCount = 0;
            boolean isPossible = true;

            for (Point point : points) {
                if (point.isStart) {
                    if (activeCount == 2) {
                        isPossible = false;
                        break;
                    } else {
                        activeCount++;
                        int freeIndex = (active[0] == -1) ? 0 : 1;
                        active[freeIndex] = point.id;
                        assignment[point.id] = (freeIndex == 0) ? 'C' : 'J';
                    }
                } else {
                    activeCount--;
                    int usedIndex = (active[0] == point.id) ? 0 : 1;
                    active[usedIndex] = -1;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + z + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + z + ": ");
                for (char c : assignment) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
    }

    public static class PointComparator implements Comparator<Point> {
        public int compare(Point p1, Point p2) {
            if (p1.pos != p2.pos) {
                return p1.pos - p2.pos;
            } else {
                return p1.isStart ? -1 : 1;
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}