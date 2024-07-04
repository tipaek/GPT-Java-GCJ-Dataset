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

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[i] = new Interval(start, end);
            }

            Arrays.sort(intervals, new Comparator<Interval>() {
                public int compare(Interval a, Interval b) {
                    return Integer.compare(a.start, b.start);
                }
            });

            boolean isPossible = true;
            StringBuilder schedule = new StringBuilder();
            schedule.append("C");

            int cameronEnd = intervals[0].end;
            int jamieEnd = -1;

            for (int i = 1; i < n; i++) {
                if (intervals[i].start >= jamieEnd) {
                    schedule.append("J");
                    jamieEnd = intervals[i].end;
                } else if (intervals[i].start >= cameronEnd) {
                    schedule.append("C");
                    cameronEnd = intervals[i].end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + testCase + ": " + schedule);
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }
}