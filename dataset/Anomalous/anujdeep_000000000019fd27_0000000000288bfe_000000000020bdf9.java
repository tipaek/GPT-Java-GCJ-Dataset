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

        for (int k = 1; k <= testCases; k++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[i] = new Interval(start, end);
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));

            int cameronEnd = intervals[0].end;
            int jamieEnd = -1;
            boolean impossible = false;
            StringBuilder schedule = new StringBuilder("C");

            for (int i = 1; i < n; i++) {
                if (cameronEnd <= intervals[i].start) {
                    schedule.append("C");
                    cameronEnd = intervals[i].end;
                } else if (jamieEnd <= intervals[i].start) {
                    schedule.append("J");
                    jamieEnd = intervals[i].end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + k + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + k + ": " + schedule);
            }
        }
    }
}