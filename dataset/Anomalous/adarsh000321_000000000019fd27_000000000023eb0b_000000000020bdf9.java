import java.awt.*;
import java.io.*;
import java.util.*;

public class Solution {
    static class Point {
        int x, y, index;

        Point(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }

    static Point[] points;
    static Point[] tempPoints;
    static int n;

    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        StringBuilder result = new StringBuilder();

        for (int testCase = 1; testCase <= t; testCase++) {
            StringBuilder sb = new StringBuilder();
            sb.append("Case #").append(testCase).append(": ");
            n = sc.nextInt();
            points = new Point[n];
            tempPoints = new Point[n];

            for (int i = 0; i < n; i++) {
                points[i] = new Point(sc.nextInt(), sc.nextInt(), i);
                tempPoints[i] = new Point(points[i].x, points[i].y, 0);
            }

            Arrays.sort(points, (o1, o2) -> {
                if (o1.x == o2.x) {
                    return o1.y - o2.y;
                }
                return o1.x - o2.x;
            });

            char[] assignedTasks = new char[n];
            Arrays.fill(assignedTasks, '0');
            assignedTasks[points[0].index] = 'J';
            Point previous = points[0];

            for (int i = 1; i < n; i++) {
                if (!intersects(points[i], previous)) {
                    assignedTasks[points[i].index] = 'J';
                    previous = points[i];
                }
            }

            for (int i = 0; i < n; i++) {
                if (assignedTasks[i] == '0') {
                    assignedTasks[i] = 'C';
                }
            }

            if (isValidAssignment(assignedTasks)) {
                sb.append(String.valueOf(assignedTasks));
            } else {
                sb.append("IMPOSSIBLE");
            }

            sb.append("\n");
            result.append(sb);
        }

        System.out.print(result);
    }

    static boolean isValidAssignment(char[] assignedTasks) {
        for (int i = 0; i < assignedTasks.length; i++) {
            if (assignedTasks[i] == 'C') {
                for (int j = 0; j < assignedTasks.length; j++) {
                    if (i != j && assignedTasks[j] == 'C' && intersects(tempPoints[i], tempPoints[j])) {
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < assignedTasks.length; i++) {
            if (assignedTasks[i] == 'J') {
                for (int j = 0; j < assignedTasks.length; j++) {
                    if (i != j && assignedTasks[j] == 'J' && intersects(tempPoints[i], tempPoints[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static boolean intersects(Point p1, Point p2) {
        return (p1.x > p2.x && p1.x < p2.y) || (p1.y > p2.x && p1.y < p2.y);
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