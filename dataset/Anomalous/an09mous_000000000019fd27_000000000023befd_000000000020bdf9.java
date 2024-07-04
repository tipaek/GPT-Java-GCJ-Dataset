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

            int[] result = new int[n];
            Interval jInterval = new Interval(-1, -1, -1);
            Interval cInterval = new Interval(-1, -1, -1);
            boolean possible = true;

            for (Interval interval : intervals) {
                if (!isOverlapping(jInterval, interval)) {
                    result[interval.index] = 0;
                    jInterval = interval;
                } else if (!isOverlapping(cInterval, interval)) {
                    result[interval.index] = 1;
                    cInterval = interval;
                } else {
                    possible = false;
                    break;
                }
            }

            StringBuilder answer = new StringBuilder();
            if (!possible) {
                answer.append("IMPOSSIBLE");
            } else {
                for (int res : result) {
                    answer.append(res == 0 ? 'J' : 'C');
                }
            }
            out.println("Case #" + test + ": " + answer);
        }
        out.flush();
        out.close();
    }
}