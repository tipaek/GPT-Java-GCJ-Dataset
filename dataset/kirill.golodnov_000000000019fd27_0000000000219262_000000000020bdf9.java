import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in, UTF_8), 1 << 15);
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out, UTF_8), 1 << 15)) {
            int tests = parseInt(in.readLine().trim());
            for (int t = 0; t < tests; t++) {
                int n = parseInt(in.readLine().trim());
                Point[] points = new Point[2 * n];
                for (int i = 0; i < n; i++) {
                    StringTokenizer tokens = new StringTokenizer(in.readLine());
                    int x = parseInt(tokens.nextToken());
                    int y = parseInt(tokens.nextToken());
                    points[2 * i] = new Point(x, 2 * i, 0, null);
                    points[2 * i + 1] = new Point(y, 2 * i + 1, 1, points[2 * i]);
                }
                Arrays.sort(points, (o1, o2) -> {
                    if (o1.time != o2.time) {
                        return o1.time - o2.time;
                    }
                    return o2.status - o1.status;
                });
                boolean cu = false;
                boolean ju = false;
                boolean failed = false;
                for (Point point : points) {
                    if (point.status == 0) {
                        if (cu && ju) {
                            failed = true;
                            break;
                        } else if (cu) {
                            ju = true;
                            point.c = 'J';
                        } else {
                            cu = true;
                            point.c = 'C';
                        }
                    } else {
                        if (point.parent.c == 'J') {
                            ju = false;
                        } else {
                            cu = false;
                        }
                    }
                }
                if (failed) {
                    out.write("Case #" + (t + 1) + ": IMPOSSIBLE");
                    out.newLine();
                } else {
                    StringBuilder result = new StringBuilder();
                    Arrays.sort(points, Comparator.comparingInt(o -> o.realPos));
                    for (int i = 0; i < points.length / 2; i++) {
                        result.append(points[2 * i].c);
                    }
                    out.write("Case #" + (t + 1) + ": " + result);
                    out.newLine();
                }
            }
        } catch (IOException e) {
            System.exit(1);
        }
    }

    private static class Point {

        int time;
        int status;
        int realPos;
        Point parent;
        char c;

        public Point(int time, int realPos, int status, Point parent) {
            this.time = time;
            this.realPos = realPos;
            this.status = status;
            this.parent = parent;
        }
    }
}
