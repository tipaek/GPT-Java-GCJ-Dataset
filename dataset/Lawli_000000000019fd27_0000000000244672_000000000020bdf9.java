import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<Interval> intervals = new ArrayList<>();

            for(int j = 0; j < n; ++j) {
                int start = in.nextInt();
                int end = in.nextInt();
                intervals.add(new Interval(j, start, end));
            }

            intervals.sort((o1, o2) -> {
                int r = Integer.compare(o1.start, o2.start);
                if(r == 0) {
                    return r;
                }
                return Integer.compare(o1.end, o2.end);
            });

            System.out.println("Case #" + i + ": " + solve(intervals, n));
        }
    }

    private static String solve(List<Interval> intervals, int n) {
        if(intervals.isEmpty()) {
            return "";
        }

        char[] result = new char[n];

        boolean jamie = false;

        Iterator<Interval> intervalIterator = intervals.iterator();

        Interval secondLatestPrev = null;
        Interval latestPrev = intervalIterator.next();

        result[latestPrev.index] = 'C';

        while(intervalIterator.hasNext()) {
            Interval current = intervalIterator.next();

            if(current.start >= latestPrev.end) {
                result[current.index] = jamie ? 'J' : 'C';

                secondLatestPrev = null;
                latestPrev = current;
            } else {
                if(secondLatestPrev != null && current.start < secondLatestPrev.end) {
                    return "IMPOSSIBLE";
                }

                jamie = !jamie;
                result[current.index] = jamie ? 'J' : 'C';

                if(current.end > latestPrev.end) {
                    secondLatestPrev = latestPrev;
                    latestPrev = current;
                } else if(secondLatestPrev == null || current.end > secondLatestPrev.end) {
                    secondLatestPrev = current;
                }
            }
        }

        return new String(result);
    }

    private static class Interval {
        private final int index;
        private final int start;
        private final int end;

        private Interval(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }
}
