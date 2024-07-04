import java.io.*;
import java.util.*;
import java.awt.Point;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            int caseNumber = 0;

            while (T-- > 0) {
                int N = Integer.parseInt(br.readLine());
                boolean[] jack = new boolean[1441];
                boolean[] cam = new boolean[1441];
                boolean impossible = false;
                List<Point> intervals = new ArrayList<>();

                for (int i = 0; i < N; i++) {
                    String[] input = br.readLine().trim().split("\\s+");
                    Point interval = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
                    intervals.add(interval);
                }

                StringBuilder result = new StringBuilder();
                caseNumber++;

                for (Point interval : intervals) {
                    if (isValid(jack, interval) && !isValid(cam, interval)) {
                        markInterval(jack, interval.x, interval.y);
                        result.append("J");
                    } else if (!isValid(jack, interval) && isValid(cam, interval)) {
                        markInterval(cam, interval.x, interval.y);
                        result.append("C");
                    } else if (!isValid(jack, interval) && !isValid(cam, interval)) {
                        System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                        impossible = true;
                        break;
                    } else if (isValid(jack, interval) && isValid(cam, interval)) {
                        markInterval(cam, interval.x, interval.y);
                        result.append("C");
                    }
                }

                if (!impossible) {
                    System.out.println("Case #" + caseNumber + ": " + result.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static boolean isValid(boolean[] schedule, Point interval) {
        for (int i = interval.x; i < interval.y; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    static void markInterval(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }
}