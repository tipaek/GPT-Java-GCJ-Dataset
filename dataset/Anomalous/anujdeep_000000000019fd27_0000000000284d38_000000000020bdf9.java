import java.util.*;
import java.io.*;

public class Solution {
    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[i] = new Interval(start, end);
            }

            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.start));

            int cameronEnd = -1;
            int jamieEnd = intervals[0].end;
            boolean possible = true;
            StringBuilder result = new StringBuilder("J");

            for (int i = 1; i < n; i++) {
                if (jamieEnd <= intervals[i].start) {
                    result.append("J");
                    jamieEnd = intervals[i].end;
                } else if (cameronEnd <= intervals[i].start) {
                    result.append("C");
                    cameronEnd = intervals[i].end;
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + t + ": " + result);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}