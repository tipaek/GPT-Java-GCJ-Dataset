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

        for (int i = 1; i <= t; i++) {
            int eventCount = scanner.nextInt();
            List<Point> points = new ArrayList<>();
            Map<Integer, String> assignments = new TreeMap<>();

            for (int j = 0; j < eventCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                points.add(new Point(start, true, j));
                points.add(new Point(end, false, j));
                assignments.put(j, "X");
            }

            points.sort((p1, p2) -> {
                if (p1.time == p2.time) {
                    return Boolean.compare(p1.isStart, p2.isStart);
                }
                return Integer.compare(p1.time, p2.time);
            });

            String result = "";
            int activeEvents = 0;
            int cameronTask = -1, jamieTask = -1;

            for (Point point : points) {
                if (activeEvents > 2) {
                    result = "IMPOSSIBLE";
                    break;
                }

                if (!point.isStart) {
                    activeEvents--;
                    if (point.uid == cameronTask) {
                        cameronTask = -1;
                    } else if (point.uid == jamieTask) {
                        jamieTask = -1;
                    }
                } else {
                    activeEvents++;
                    if (cameronTask == -1) {
                        cameronTask = point.uid;
                        assignments.put(point.uid, "C");
                    } else if (jamieTask == -1) {
                        jamieTask = point.uid;
                        assignments.put(point.uid, "J");
                    }
                }
            }

            if (!"IMPOSSIBLE".equals(result)) {
                StringBuilder resBuilder = new StringBuilder();
                for (int r = 0; r < eventCount; r++) {
                    resBuilder.append(assignments.get(r));
                }
                result = resBuilder.toString();
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}