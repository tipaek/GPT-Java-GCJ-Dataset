import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Point {
        int time;
        boolean isStart;
        int uid;

        Point(int time, boolean isStart, int uid) {
            this.time = time;
            this.isStart = isStart;
            this.uid = uid;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            int eventCount = scanner.nextInt();
            List<Point> points = new ArrayList<>();

            for (int j = 0; j < eventCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                points.add(new Point(start, true, j));
                points.add(new Point(end, false, j));
            }

            points.sort((p1, p2) -> {
                if (p1.time == p2.time) {
                    return Boolean.compare(p1.isStart, p2.isStart);
                }
                return Integer.compare(p1.time, p2.time);
            });

            StringBuilder result = new StringBuilder();
            int activeCount = 0;
            int cAssigned = -1, jAssigned = -1;

            for (Point point : points) {
                if (activeCount > 2) {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }

                if (!point.isStart) {
                    if (point.uid == cAssigned) {
                        cAssigned = -1;
                    } else if (point.uid == jAssigned) {
                        jAssigned = -1;
                    }
                    activeCount--;
                } else {
                    activeCount++;
                    if (cAssigned == -1) {
                        result.append("C");
                        cAssigned = point.uid;
                    } else if (jAssigned == -1) {
                        result.append("J");
                        jAssigned = point.uid;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}