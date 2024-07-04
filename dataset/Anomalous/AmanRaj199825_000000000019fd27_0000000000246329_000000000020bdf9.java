import java.io.*;
import java.util.*;
import java.awt.Point;

class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            while (T-- > 0) {
                int N = Integer.parseInt(br.readLine());
                boolean[] jack = new boolean[1441];
                boolean[] cam = new boolean[1441];
                boolean flag = false;
                List<Point> intervals = new ArrayList<>();

                for (int i = 0; i < N; i++) {
                    String[] input = br.readLine().trim().split("\\s+");
                    Point interval = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
                    intervals.add(interval);
                }

                StringBuilder schedule = new StringBuilder();

                for (Point interval : intervals) {
                    if (isValid(jack, interval) && !isValid(cam, interval)) {
                        markOccupied(jack, interval.x, interval.y);
                        schedule.append("J");
                    } else if (!isValid(jack, interval) && isValid(cam, interval)) {
                        markOccupied(cam, interval.x, interval.y);
                        schedule.append("C");
                    } else if (!isValid(jack, interval) && !isValid(cam, interval)) {
                        System.out.println("IMPOSSIBLE");
                        flag = true;
                        break;
                    } else if (isValid(jack, interval) && isValid(cam, interval)) {
                        markOccupied(cam, interval.x, interval.y);
                        schedule.append("C");
                    }
                }

                if (!flag) {
                    System.out.println(schedule.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isValid(boolean[] schedule, Point interval) {
        for (int i = interval.x; i < interval.y; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private static void markOccupied(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }
}