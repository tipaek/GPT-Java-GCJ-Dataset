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

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[i] = new Interval(start, end);
            }

            Arrays.sort(intervals, new Comparator<Interval>() {
                public int compare(Interval a, Interval b) {
                    return a.start - b.start;
                }
            });

            StringBuilder schedule = new StringBuilder();
            boolean isPossible = true;
            int cameronEnd = 0, jamieEnd = 0;

            for (Interval interval : intervals) {
                if (interval.start >= cameronEnd) {
                    schedule.append("C");
                    cameronEnd = interval.end;
                } else if (interval.start >= jamieEnd) {
                    schedule.append("J");
                    jamieEnd = interval.end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + caseNum + ": " + schedule.toString());
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
        scanner.close();
    }
}