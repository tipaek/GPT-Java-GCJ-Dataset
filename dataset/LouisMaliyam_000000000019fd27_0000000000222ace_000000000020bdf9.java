import java.util.*;
import java.io.*;

public class Solution {
    private static class Interval implements Comparable<Interval> {
        public int start;
        public int end;
        public int index;

        public Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Interval o) {
            return this.start == o.start ? this.start - o.start : this.end - o.end;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            int n = in.nextInt();
            List<Interval> intervals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int s = in.nextInt();
                int e = in.nextInt();
                intervals.add(new Interval(s, e, i));
            }
            intervals.sort(null);

            char[] output = new char[n];
            int cEnd = 0;
            int jEnd = 0;
            boolean impossible = false;
            for (Interval interval : intervals) {
                if (interval.start >= cEnd) {
                    cEnd = interval.end;
                    output[interval.index] = 'C';
                } else if (interval.start >= jEnd) {
                    jEnd = interval.end;
                    output[interval.index] = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }
            System.out.print("Case #" + t + ": ");
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(String.valueOf(output));
            }
        }
    }
}
