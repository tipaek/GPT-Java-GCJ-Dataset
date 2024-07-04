import java.util.*;
import java.io.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    static class Interval {
        int start, end, id;

        Interval(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
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

            Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));
            StringBuilder result = new StringBuilder();
            int valid = 1, currentAssignment = 0;
            int[] assignments = new int[n];

            for (int i = 0; i < n; i++) {
                if (i + 1 < n && isOverlapping(intervals[i], intervals[i + 1])) {
                    if (i + 2 < n && isOverlapping(intervals[i + 1], intervals[i + 2]) && isOverlapping(intervals[i], intervals[i + 2])) {
                        valid = 0;
                        break;
                    }
                    assignments[intervals[i].id] = currentAssignment;
                    currentAssignment ^= 1;
                } else {
                    assignments[intervals[i].id] = currentAssignment;
                }
            }

            if (valid == 0) {
                result.append("IMPOSSIBLE");
            } else {
                for (int assignment : assignments) {
                    result.append(assignment == 0 ? 'C' : 'J');
                }
            }

            out.println("Case #" + test + ": " + result);
        }
        out.flush();
        out.close();
    }
}