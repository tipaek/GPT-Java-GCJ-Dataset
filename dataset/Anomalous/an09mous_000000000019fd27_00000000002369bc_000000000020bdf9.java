import java.util.*;
import java.io.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    static class Interval {
        int start, end, index;

        Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    static boolean isOverlapping(Interval a, Interval b) {
        return b.start < a.end;
    }

    public static void main(String[] args) {
        int testCases = sc.nextInt();
        for (int test = 1; test <= testCases; test++) {
            int n = sc.nextInt();
            Interval[] intervals = new Interval[n];
            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(sc.nextInt(), sc.nextInt(), i);
            }

            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.start));

            StringBuilder result = new StringBuilder();
            int isPossible = 1;
            int currentVal = 0;
            int[] assignments = new int[n];

            for (int i = 0; i < n; i++) {
                if (i + 1 < n && isOverlapping(intervals[i], intervals[i + 1])) {
                    if (i + 2 < n && isOverlapping(intervals[i + 1], intervals[i + 2]) && isOverlapping(intervals[i], intervals[i + 2])) {
                        isPossible = 0;
                        break;
                    }
                    assignments[intervals[i].index] = currentVal;
                    assignments[intervals[i + 1].index] = currentVal ^ 1;
                    currentVal ^= 1;
                } else {
                    assignments[intervals[i].index] = currentVal;
                }
            }

            if (isPossible == 0) {
                result.append("IMPOSSIBLE");
            } else {
                for (int x : assignments) {
                    result.append(x == 0 ? 'J' : 'C');
                }
            }

            out.println("Case #" + test + ": " + result);
        }
        out.flush();
        out.close();
    }
}