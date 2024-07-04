import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static class Interval {
        int start, end;
        int order;
        Interval(int start, int end, int order) {
            this.start = start;
            this.end = end;
            this.order = order;
        }
        @Override
        public String toString() {
            return String.format("[%d - %d]", start, end);
        }
    }

    private static String solve(List<Interval> intervals) {
        int c = 0;
        int j = 0;
        char[] result = new char[intervals.size()];
        for (Interval interval : intervals) {
            if (c <= interval.start) {
                c = interval.end;
                result[interval.order] = 'C';
            } else if (j <= interval.start) {
                j = interval.end;
                result[interval.order] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; ++i) {
            int n  = in.nextInt();
            List<Interval> intervals = new ArrayList<>(n);
            for (int j = 0; j < n; ++j) {
                intervals.add(new Interval(in.nextInt(), in.nextInt(), j));
            }
            intervals.sort((a, b) -> {
                if (a.start == b.start) {
                    return a.end - b.end;
                } else {
                    return a.start - b.start;
                }
            });

            System.out.println("Case #" + (i + 1) + ": " + solve(intervals));
        }
    }
}
