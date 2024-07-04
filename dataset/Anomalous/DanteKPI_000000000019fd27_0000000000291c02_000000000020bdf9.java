import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final char C = 'C';
    private static final char J = 'J';

    static class Interval {
        int pos;
        int start;
        int end;

        public Interval(int pos, int start, int end) {
            this.pos = pos;
            this.start = start;
            this.end = end;
        }
    }

    public static String solve(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(o -> o.start));

        int c = 0;
        int j = 0;
        char[] result = new char[intervals.size()];

        for (Interval interval : intervals) {
            if (c <= interval.start) {
                c = interval.end;
                result[interval.pos] = C;
            } else if (j <= interval.start) {
                j = interval.end;
                result[interval.pos] = J;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();

        for (int test = 1; test <= tests; test++) {
            int total = in.nextInt();
            List<Interval> intervals = new ArrayList<>(total);

            for (int i = 0; i < total; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                intervals.add(new Interval(i, start, end));
            }
            System.out.println("Case #" + test + ": " + solve(intervals));
        }
    }
}